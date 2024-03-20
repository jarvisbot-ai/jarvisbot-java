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

package com.jarvisbot.sdk.common.defaut;

import com.jarvisbot.sdk.entity.req.TtsReq;

public class Tts {

    public static TtsReq defaultTts(String text) {
        TtsReq ttsReq = new TtsReq();
        ttsReq.setSpeakerId("female");
        ttsReq.setReturnB64(true);
        ttsReq.setModel("tts-1");
        ttsReq.setText(text);
        ttsReq.setSpeed(1);
        return ttsReq;
    }

}
