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

package com.jarvisbot.sdk.entity.res;

import lombok.Data;

@Data
public class BaseResult<T> {

    public BaseResult() {

    }

    public static int ok = 0;

    public static int fail = 1;

    private Integer code;

    private String msg;

    private T data;


    public boolean isFail() {
        return code == fail;
    }

}
