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

package com.jarvisbot.sdk.entity.req.chat;

import com.jarvisbot.sdk.common.validation.ValueValid;
import lombok.Data;


@Data
@ValueValid
public class ChatFun {

    /**
     * not null
     * The name of the function to be called.
     * Must be a-z, A-Z, 0-9, or contain underscores
     * and dashes, with a maximum length of 64.
     */
    private String name;

    /**
     * null
     * A description of what the function does,
     * used by the model to choose when and how to call the function.
     */
    private String description;

    /**
     * null
     * any of (integer | string | boolean | array<any> | object | null)
     * The parameters the functions accepts, described as a JSON Schema object.
     * See the guide for examples, and the JSON Schema reference for
     * documentation about the format.
     */
    private Object parameters;
}
