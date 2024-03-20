/*
 * Copyright 2024 JarvisBot.ai. All rights reserved.
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

package com.jarvisbot.sdk.respository;

import com.alibaba.fastjson.TypeReference;
import com.jarvisbot.sdk.common.exception.JarvisException;
import com.jarvisbot.sdk.common.observe.Emitter;
import com.jarvisbot.sdk.common.utils.ConfigReaderUtil;
import com.jarvisbot.sdk.common.utils.HttpUtils;
import com.jarvisbot.sdk.entity.req.*;
import com.jarvisbot.sdk.entity.res.*;
import com.jarvisbot.sdk.entity.req.*;
import com.jarvisbot.sdk.entity.res.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

class ApiServiceImpl implements ApiService {

    private final HttpUtils httpUtils = new HttpUtils();

    private final AtomicReference<TokenRes> tokenRes = new AtomicReference<>();

    ApiServiceImpl() {

    }

    ApiServiceImpl(String host, Integer port) {
        httpUtils.proxy(host, port);
    }

    @Override
    public TokenRes token(String token) {
        String url;
        try {
            url = new ConfigReaderUtil().getProperty("jarvisClient");
        } catch (IOException e) {
            throw new JarvisException(e);
        }
        url = url + "/jarvis/v1/token/api/check/" + token;
        TypeReference<BaseResult<TokenRes>> type = new TypeReference<BaseResult<TokenRes>>() {
        };
        BaseResult<TokenRes> result = httpUtils.get(url, type);
        if (result == null || result.isFail()) {
            throw new JarvisException("authentication failed");
        }
        httpUtils.authentication(token);
        tokenRes.set(result.getData());
        return result.getData();
    }

    @Override
    public void chatSee(ChatReq req, Emitter<ChatRes> emitter) {
        TokenRes res = tokenRes.get();
        httpUtils.reqSse(res.getChat(), req, emitter, ChatRes.class);
    }

    @Override
    public ChatRes chat(ChatReq req) {
        TokenRes res = tokenRes.get();
        return httpUtils.req(res.getChat(), req, ChatRes.class);
    }

    @Override
    public ImgRes txt2img(Txt2imgReq req) {
        TokenRes res = tokenRes.get();
        return httpUtils.req(res.getTxt2img(), req, ImgRes.class);
    }

    @Override
    public ImgRes img2img(Img2imgReq req) {
        TokenRes res = tokenRes.get();
        return httpUtils.req(res.getImg2img(), req, ImgRes.class);
    }

    @Override
    public byte[] tts(TtsReq req) {
        TokenRes res = tokenRes.get();
        return httpUtils.req(res.getTts(), req);
    }

    @Override
    public AsrRes asr(AsrReq req) {
        TokenRes res = tokenRes.get();
        return httpUtils.req(res.getAsr(), req, AsrRes.class);
    }

//    @Override
//    public ChatModelRes chatModels() {
//        TokenRes res = tokenRes.get();
//        return null;
//    }
}
