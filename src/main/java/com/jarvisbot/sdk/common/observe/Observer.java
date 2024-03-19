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

package com.jarvisbot.sdk.common.observe;


import com.jarvisbot.sdk.common.exception.JarvisException;
import com.jarvisbot.sdk.common.interfaces.I1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class Observer<T> {

    private Observer() {

    }

    private I1<Emitter<T>> observable;

    private ExecutorService executorService;


    public static <U> Observer<U> create(I1<Emitter<U>> observable, ExecutorService executorService) {
        Observer<U> observer = new Observer<U>();
        observer.executorService = executorService;
        observer.observable = observable;
        return observer;
    }


    public void observe(Consumer<T> consumer) {
        if (consumer == null) {
            throw new JarvisException("consumer is not allowed to be null");
        }
        Emitter<T> emitter = new Emitter<>(consumer);
        executorService.execute(() -> {
            try {
                observable.apply(emitter);
            } catch (Exception e) {
                consumer.onError(e);
            } finally {
                consumer.completed();
                observable = null;
                executorService = null;
            }
        });
    }

    public void observeBlock(Consumer<T> consumer) {
        if (consumer == null) {
            throw new JarvisException("consumer is not allowed to be null");
        }
        Semaphore semaphore = new Semaphore(0);
        Emitter<T> emitter = new Emitter<>(consumer);
        executorService.execute(() -> {
            try {
                observable.apply(emitter);
            } catch (Exception e) {
                consumer.onError(e);
            } finally {
                semaphore.release();
                consumer.completed();
            }
        });
        semaphore.acquireUninterruptibly();
        observable = null;
        executorService = null;
    }

}
