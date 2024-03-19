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

package com.jarvisbot.sdk.common.log;

public final class Log {

    private static ILog iLog = new LoggerImpl();

    public static void init(ILog log) {
        iLog = log;
    }

    public static void i(String tag, String message) {
        iLog.i(tag, message);
    }

    public static void w(String tag, String message) {
        iLog.i(tag, message);
    }

    public static void d(String tag, String message) {
        iLog.d(tag, message);
    }

    public static void e(String tag, String message) {
        iLog.e(tag, message);
    }

    public static void e(String tag, String message, Throwable throwable) {
        iLog.e(tag, message, throwable);
    }


}
