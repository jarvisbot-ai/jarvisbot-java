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

package com.jarvisbot.sdk.entity.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.jarvisbot.sdk.entity.req.tts.ResponseFormat;
import lombok.Data;

@Data
public class TtsReq {

    /**
     * default ""
     */
    @JSONField(name = "app_key")
    private String appKey;

    @JSONField(name = "response_format")
    private ResponseFormat responseFormat;

    /**
     * default ""
     */
    @JSONField(name = "speaker_id")
    private String speakerId;

    /**
     * default true
     */
    @JSONField(name = "return_b64")
    private boolean returnB64;

    /**
     * default ""
     */
    @JSONField(name = "model")
    private String model;

    /**
     * default ""
     */
    @JSONField(name = "text")
    private String text;

    /**
     * default ""
     */
    @JSONField(name = "app_id")
    private String appId;

    /**
     * default ""
     */
    @JSONField(name = "app_origin")
    private String appOrigin;

    /**
     * default ""
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * default 1
     */
    @JSONField(name = "speed")
    private int speed;

    /**
     * default ""
     */
    @JSONField(name = "peer_id")
    private String peerId;

}