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

package com.jarvisbot.sdk.base;

import com.jarvisbot.sdk.common.utils.JarvisFuture;
import com.jarvisbot.sdk.common.observe.Observer;
import com.jarvisbot.sdk.entity.req.*;
import com.jarvisbot.sdk.entity.res.AsrRes;
import com.jarvisbot.sdk.entity.res.ChatRes;
import com.jarvisbot.sdk.entity.res.ImgRes;
import com.jarvisbot.sdk.entity.req.*;


public interface IJarvisBot {

    JarvisFuture<ChatRes> chat(ChatReq chatReq);

    Observer<ChatRes> chatSee(ChatReq chatReq);

    JarvisFuture<ImgRes> txt2img(Txt2imgReq imgReq);

    JarvisFuture<ImgRes> img2img(Img2imgReq imgReq);

    JarvisFuture<byte[]> tts(TtsReq ttsReq);

    JarvisFuture<AsrRes> asr(AsrReq asrReq);

}

