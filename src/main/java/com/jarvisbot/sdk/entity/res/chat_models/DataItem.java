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

package com.jarvisbot.sdk.entity.res.chat_models;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class DataItem {

    @JSONField(name = "filename")
    private String filename;

    @JSONField(name = "model_name")
    private String modelName;

    @JSONField(name = "sha256")
    private String sha256;

    @JSONField(name = "permissions")
    private List<String> permissions;

    @JSONField(name = "owned_by")
    private String ownedBy;

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "config")
    private Config config;

    @JSONField(name = "hash")
    private String hash;

    @JSONField(name = "object")
    private String object;
}