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

package com.jarvisbot.sdk.common;

import com.jarvisbot.sdk.common.interfaces.I1;
import lombok.Data;

/**
 * @author: longqing.zhao
 */
@Data
@SuppressWarnings("unused")
public class Result<T> {

    private Boolean success;
    private T data;
    private Throwable throwable;


    private Result() {
    }

    public static Result<?> fail(Throwable throwable) {
        Result<?> result = new Result<>();
        result.throwable = throwable;
        result.success = false;
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.data = data;
        result.success = true;
        return result;
    }


    public boolean isSuccess() {
        return success;
    }

    public boolean isFailed() {
        return !success;
    }

    public void fold(I1<T> success, I1<Throwable> error) {
        if (this.success) {
            success.apply(data);
        } else {
            error.apply(throwable);
        }
    }

    public void success(I1<T> success) {
        if (this.success) {
            success.apply(data);
        }
    }

    public void error(I1<Throwable> error) {
        if (!this.success) {
            error.apply(throwable);
        }
    }

}
