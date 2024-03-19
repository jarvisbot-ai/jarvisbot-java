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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Objects;

@SuppressWarnings("unused")
public class JsonUtils {

    public static <T> String toJsonWithNull(T data) {
        if (Objects.isNull(data)) {
            throw new NullPointerException();
        }
        return JSON.toJSONString(data);
    }

    public static <T> String toJson(T data) {
        if (Objects.isNull(data)) {
            throw new NullPointerException();
        }
        return JSON.toJSONString(data);
    }

    public static <T> T parseData(String data, Class<T> clz) {
        if (StringUtils.isEmpty(data)) {
            throw new NullPointerException("response data is empty");
        }
        return JSON.parseObject(data, clz);
    }

    public static <T> T parseData(String data, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(data)) {
            throw new NullPointerException("response data is empty");
        }
        return JSON.parseObject(data, typeReference);
    }

}
