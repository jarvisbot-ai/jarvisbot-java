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

import com.jarvisbot.sdk.common.observe.Observer;
import com.jarvisbot.sdk.common.utils.JarvisFuture;
import com.jarvisbot.sdk.entity.req.*;
import com.jarvisbot.sdk.entity.res.AsrRes;
import com.jarvisbot.sdk.entity.res.ChatRes;
import com.jarvisbot.sdk.entity.res.ImgRes;
import com.jarvisbot.sdk.entity.res.TokenRes;
import com.jarvisbot.sdk.entity.req.*;

import java.util.concurrent.ExecutorService;

public class ApiManager {

    private final ApiService apiService;

    private final ExecutorService executorService;

    public ApiManager(ExecutorService executorService) {
        apiService = new ApiServiceImpl();
        this.executorService = executorService;
    }

    public JarvisFuture<TokenRes> token(String token) {
        return JarvisFuture.supplyAsync(
                () -> apiService.token(token),
                executorService
        );
    }

    public Observer<ChatRes> chatSee(ChatReq req) {
        return Observer.create(
                (emitter) -> apiService.chatSee(req, emitter),
                executorService
        );
    }

    public JarvisFuture<ChatRes> chat(ChatReq req) {
        return JarvisFuture.supplyAsync(
                () -> apiService.chat(req),
                executorService
        );
    }

    public JarvisFuture<ImgRes> txt2Img(Txt2imgReq req) {
        return JarvisFuture.supplyAsync(
                () -> apiService.txt2img(req),
                executorService
        );
    }

    public JarvisFuture<ImgRes> img2Img(Img2imgReq req) {
        return JarvisFuture.supplyAsync(
                () -> apiService.img2img(req),
                executorService
        );
    }

    public JarvisFuture<byte[]> tts(TtsReq req) {
        return JarvisFuture.supplyAsync(
                () -> apiService.tts(req),
                executorService
        );
    }

    public JarvisFuture<AsrRes> asr(AsrReq req) {
        return JarvisFuture.supplyAsync(
                () -> apiService.asr(req),
                executorService
        );
    }


}
