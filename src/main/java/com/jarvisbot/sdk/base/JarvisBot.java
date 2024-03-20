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

package com.jarvisbot.sdk.base;

import com.jarvisbot.sdk.common.log.Log;
import com.jarvisbot.sdk.common.utils.JarvisFuture;
import com.jarvisbot.sdk.common.observe.Observer;
import com.jarvisbot.sdk.entity.req.*;
import com.jarvisbot.sdk.entity.res.AsrRes;
import com.jarvisbot.sdk.entity.res.ChatRes;
import com.jarvisbot.sdk.entity.res.ImgRes;
import com.jarvisbot.sdk.respository.ApiManager;
import com.jarvisbot.sdk.entity.req.*;

import java.util.concurrent.ExecutorService;

class JarvisBot implements IJarvisBot {

    private static final String TAG = "AiClient";

    private final ApiManager apiManager;

    private final ExecutorService executorService;

    public JarvisBot(ApiManager apiManager, ExecutorService executorService) {
        Log.d(TAG, "init");
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        boolean inInvokeMethod = false;
        for (StackTraceElement element : stackTraceElements) {
            if (element.getClassName().equals("com.jarvisbot.sdk.base.AntiReflectionProxy") && element.getMethodName().equals("invoke")) {
                inInvokeMethod = true;
                break;
            }
        }
        if (!inInvokeMethod) {
            throw new RuntimeException("JarvisBot the constructor is called outside the invoke method");
        }
        this.apiManager = apiManager;
        this.executorService = executorService;
    }

    @Override
    public JarvisFuture<ChatRes> chat(ChatReq chatReq) {
        return apiManager.chat(chatReq);
    }


    @Override
    public JarvisFuture<ImgRes> txt2img(Txt2imgReq imgReq) {
        return apiManager.txt2Img(imgReq);
    }

    @Override
    public JarvisFuture<ImgRes> img2img(Img2imgReq imgReq) {
        return apiManager.img2Img(imgReq);
    }

    @Override
    public JarvisFuture<byte[]> tts(TtsReq ttsReq) {
        return apiManager.tts(ttsReq);
    }

    @Override
    public JarvisFuture<AsrRes> asr(AsrReq asrReq) {
        return apiManager.asr(asrReq);
    }

//    @Override
//    public JarvisFuture<ChatModelRes> chatModels() {
//        Log.d(TAG, "chatModels: start");
//        return apiManager
//    }

    @Override
    public Observer<ChatRes> chatSee(ChatReq chatReq) {
        chatReq.setStream(true);
        return apiManager.chatSee(chatReq);
    }

}
