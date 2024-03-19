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

package com.jarvisbot.sdk.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderUtil {

    private final Properties properties;

    public ConfigReaderUtil() throws IOException {
        this.properties = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("jarvis.properties");
        if (input == null) {
            System.out.println("Sorry, unable to find config.properties");
            return;
        }
        properties.load(input);
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}