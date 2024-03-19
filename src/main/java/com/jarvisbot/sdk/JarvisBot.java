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

package com.jarvisbot.sdk;

import cn.hutool.core.thread.ThreadUtil;
import com.jarvisbot.sdk.base.AntiReflectionProxy;
import com.jarvisbot.sdk.base.IJarvisBot;
import com.jarvisbot.sdk.common.exception.JarvisException;
import com.jarvisbot.sdk.common.log.Log;
import com.jarvisbot.sdk.common.observe.Consumer;
import com.jarvisbot.sdk.common.interfaces.I1;
import com.jarvisbot.sdk.common.utils.JarvisFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public class JarvisBot {

    private static final String TAG = "JarvisBot";

    private final AtomicReference<Semaphore> semaphore = new AtomicReference<>();

    private IJarvisBot base;

    private Throwable latestError;

    private final Object async = new Object();

    public JarvisBot(String token) {
        this(token, null, null);
    }

    public JarvisBot(String token, ExecutorService executorService) {
        this(token, executorService, null);
    }

    public JarvisBot(String token, I1<Throwable> error) {
        this(token, null, error);
    }

    public JarvisBot(String token, ExecutorService executorService, I1<Throwable> error) {
        createBot(executorService, token).async(new Consumer<IJarvisBot>() {
            @Override
            public void apply(IJarvisBot param) {
                synchronized (async) {
                    base = param;
                    latestError = null;
                }
            }

            @Override
            public void onError(Throwable e) {
                synchronized (async) {
                    base = null;
                    latestError = e;
                }
                if (error != null) {
                    error.apply(e);
                }
            }

            @Override
            public void completed() {
                Semaphore s = semaphore.get();
                if (s != null) {
                    s.release();
                }
            }
        });
    }

    public IJarvisBot base() {
        synchronized (async) {
            if (base == null) {
                if (latestError != null) {
                    throw new JarvisException(latestError);
                } else {
                    return null;
                }
            }
            return base;
        }
    }

    public IJarvisBot baseBlock() {
        synchronized (JarvisBot.class) {
            if (base == null) {
                semaphore.set(new Semaphore(0));
                semaphore.get().acquireUninterruptibly();
                semaphore.set(null);
            }
            IJarvisBot iJarvisBot = base();
            Log.d(TAG, "create:" + iJarvisBot);
            return iJarvisBot;
        }
    }

    private static JarvisFuture<IJarvisBot> createBot(ExecutorService executorService, String token) {
        ExecutorService service = executorService == null ? ThreadUtil.newExecutor() : executorService;
        return JarvisFuture.supplyAsync(
                () -> AntiReflectionProxy.createProxy(service, token),
                service
        );
    }

}
