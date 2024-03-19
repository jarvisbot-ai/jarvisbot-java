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

package com.jarvisbot.sdk.base;

import com.jarvisbot.sdk.common.exception.JarvisException;
import com.jarvisbot.sdk.entity.res.TokenRes;
import com.jarvisbot.sdk.common.utils.StringUtils;
import com.jarvisbot.sdk.respository.ApiManager;

import java.lang.reflect.*;
import java.util.concurrent.ExecutorService;

public class AntiReflectionProxy implements InvocationHandler {

    private final String token;

    private JarvisBot jarvisBot;

    private final ExecutorService executorService;

    public AntiReflectionProxy(ExecutorService executorService, String token) {
        this.token = token;
        this.executorService = executorService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (jarvisBot == null) {
            if (StringUtils.isEmpty(token)) {
                throw new JarvisException("token is empty");
            }
            if (method.getName().startsWith("set")) {
                throw new JarvisException("Reflective modification operations are prohibited");
            }
            ApiManager apiManager = new ApiManager(executorService);
            TokenRes res = apiManager.token(token).blockingGet();
            if (res == null) {
                throw new JarvisException("authentication failed");
            }
            jarvisBot = new JarvisBot(apiManager, executorService);
        }
        return method.invoke(jarvisBot, args);
    }

    public static IJarvisBot createProxy(ExecutorService executorService, String token) {
        Class<?> interfaceType = IJarvisBot.class;
        return (IJarvisBot) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new AntiReflectionProxy(executorService, token)
        );
    }
}