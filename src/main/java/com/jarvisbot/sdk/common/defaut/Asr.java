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

package com.jarvisbot.sdk.common.defaut;

import com.jarvisbot.sdk.entity.req.AsrReq;

public class Asr {

    public static AsrReq defaultAsr(String base64FileData) {
        AsrReq asrReq = new AsrReq();
        asrReq.setFiles(base64FileData);
        asrReq.setLang("en");
        asrReq.setInputFormat("mp3");
        asrReq.setResponseFormat("");
        asrReq.setTemperatureInc(0.2f);
        asrReq.setTemperature(0f);
        return asrReq;
    }

}
