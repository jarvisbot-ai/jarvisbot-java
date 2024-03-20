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
import lombok.Data;

@Data
public class AsrReq {

    /**
     * null
     * default 0.2
     */
    @JSONField(name = "temperature_inc")
    private Float temperatureInc;

    /**
     * null
     * default json
     */
    @JSONField(name = "response_format")
    private String responseFormat;

    /**
     * null
     * default 0
     */
    @JSONField(name = "temperature")
    private Float temperature;

    /**
     * default ""
     */
    @JSONField(name = "files")
    private String files;

    /**
     * default en
     */
    @JSONField(name = "lang")
    private String lang;

    /**
     * default ""
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * default wav
     */
    @JSONField(name = "input_format")
    private String inputFormat;

    @JSONField(name = "timestamp_granularities")
    private Object timestampGranularities;

}