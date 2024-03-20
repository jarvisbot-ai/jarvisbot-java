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

package com.jarvisbot.sdk.common.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LoggerImpl implements ILog {

    private static final Logger logger = Logger.getLogger(LoggerImpl.class.getName());

    public LoggerImpl() {
        logger.setLevel(Level.FINE);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        logger.addHandler(consoleHandler);
    }

    @Override
    public void i(String tag, String message) {
        logger.log(Level.INFO, tag + " - " + message);
    }

    @Override
    public void w(String tag, String message) {
        logger.log(Level.WARNING, tag + " - " + message);
    }

    @Override
    public void d(String tag, String message) {
        logger.log(Level.FINE, tag + " - " + message);
    }

    @Override
    public void e(String tag, String message) {
        logger.log(Level.SEVERE, tag + " - " + message);
    }

    @Override
    public void e(String tag, String message, Throwable throwable) {
        logger.log(Level.SEVERE, tag + " - " + message, throwable);
    }

}
