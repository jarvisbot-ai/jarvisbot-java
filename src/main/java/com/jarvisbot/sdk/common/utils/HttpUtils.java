/*
 * Copyright 2024 FanTe.Company
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jarvisbot.sdk.common.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONValidator;
import com.alibaba.fastjson.TypeReference;
import com.jarvisbot.sdk.common.exception.JarvisException;
import com.jarvisbot.sdk.common.observe.Emitter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUtils {

    private static final String TAG = "HttpUtils";

    private String host;

    private Integer port;

    private String appToken;

    public void authentication(String appToken) {
        this.appToken = appToken;
    }

    public void proxy(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public <Res> Res get(String reqUrl, TypeReference<Res> typeReference) {
        HttpRequest request = HttpRequest
                .get(reqUrl);
        if (StringUtils.isNotEmpty(appToken)) {
            request.header("App-token", appToken);
        }
        if (StringUtils.isNotEmpty(host) && port != null) {
            request.setHttpProxy(host, port);
        }
        HttpResponse response = request.execute();
        String data = response.body();
        try {
            return JsonUtils.parseData(data, typeReference);
        } catch (JSONException e) {
            throw new JarvisException(data, e);
        }
    }

    public <Res> Res get(String reqUrl, Class<Res> clz) {
        HttpRequest request = HttpRequest
                .get(reqUrl);
        if (StringUtils.isNotEmpty(appToken)) {
            request.header("App-token", appToken);
        }
        if (StringUtils.isNotEmpty(host) && port != null) {
            request.setHttpProxy(host, port);
        }
        HttpResponse response = request.execute();
        String data = response.body();
        try {
            return JsonUtils.parseData(data, clz);
        } catch (JSONException e) {
            throw new JarvisException(data, e);
        }
    }

    @SneakyThrows
    public <Req, Res> void reqSse(String reqUrl, Req req, Emitter<Res> emitter, Class<Res> resClass) {
        URL sseUrl = new URL(reqUrl);
        HttpURLConnection connection = (HttpURLConnection) sseUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "text/event-stream");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Connection", "keep-alive");
        connection.setRequestProperty("App-token", appToken);
        connection.setUseCaches(false);
        connection.setChunkedStreamingMode(0);
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
        String data = JsonUtils.toJson(req);
        osw.write(data);
        osw.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("data: [DONE]")) {
                break;
            }
            int index = line.indexOf("data:");
            String json = null;
            if (index != -1) {
                json = line.substring(index + "data:".length()).trim();
            }
            if (StringUtils.isNotEmpty(json) && JSONValidator.from(json).validate()) {
                try {
                    Res res = JsonUtils.parseData(json, resClass);
                    emitter.emit(res);
                } catch (JSONException e) {
                    throw new JarvisException(data, e);
                }
            }
        }
        osw.close();
        reader.close();
        connection.disconnect();
    }

    public <Req> byte[] req(String reqUrl, Req req) {
        String reqStr = JsonUtils.toJson(req);
        HttpRequest request = HttpRequest
                .post(reqUrl)
                .header("App-token", appToken);
        if (StringUtils.isNotEmpty(host) && port != null) {
            request.setHttpProxy(host, port);
        }
        HttpResponse response = request.body(reqStr)
                .execute();
        return response.bodyBytes();
    }

    public <Res, Req> Res req(String reqUrl, Req req, Class<Res> clz) {
        String reqStr = JsonUtils.toJson(req);
        HttpRequest request = HttpRequest
                .post(reqUrl)
                .header("App-token", appToken);
        if (StringUtils.isNotEmpty(host) && port != null) {
            request.setHttpProxy(host, port);
        }
        HttpResponse response = request.body(reqStr)
                .execute();
        String data = response.body();
        try {
            return JsonUtils.parseData(data, clz);
        } catch (JSONException e) {
            throw new JarvisException(data, e);
        }
    }


}
