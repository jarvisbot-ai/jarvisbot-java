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

import com.jarvisbot.sdk.common.observe.Consumer;
import lombok.SneakyThrows;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class JarvisFuture<T> extends CompletableFuture<T> {

    public static <U> JarvisFuture<U> supplyAsync(
            Supplier<U> supplier,
            Executor executor
    ) {
        JarvisFuture<U> jarvisFuture = new JarvisFuture<>();
        executor.execute(() -> {
            U result = null;
            try {
                result = supplier.get();
            } catch (Throwable t) {
                jarvisFuture.completeExceptionally(t);
            }
            if (!jarvisFuture.isDone()) {
                jarvisFuture.complete(result);
            }
        });
        return jarvisFuture;
    }

    @SneakyThrows
    public T blockingGet() {
        return get();
    }


    public void async(Consumer<T> consumer) {
        whenComplete((t, throwable) -> {
            try {
                if (throwable != null) {
                    consumer.onError(throwable);
                }
                if (Objects.nonNull(t)) {
                    consumer.apply(t);
                }
            } catch (Exception e) {
                consumer.onError(e);
            } finally {
                consumer.completed();

            }

        });
    }


}
