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

import com.jarvisbot.sdk.base.IJarvisBot;
import com.jarvisbot.sdk.common.defaut.*;
import com.jarvisbot.sdk.common.observe.Consumer;
import com.jarvisbot.sdk.common.utils.Lazy;
import com.jarvisbot.sdk.common.observe.Observer;
import com.jarvisbot.sdk.entity.req.ChatReq;
import com.jarvisbot.sdk.entity.req.chat.message.MessageItem;
import com.jarvisbot.sdk.entity.req.chat.message.user.MessageUserItem;
import com.jarvisbot.sdk.entity.res.AsrRes;
import com.jarvisbot.sdk.entity.res.ChatRes;
import com.jarvisbot.sdk.entity.res.ImgRes;
import com.jarvisbot.sdk.common.defaut.*;
import org.junit.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class JarvisBotTest {

    JarvisBot jarvisBotSingle = new JarvisBot("");

    Lazy<IJarvisBot> jarvisBotLazy = new Lazy<>(() -> jarvisBotSingle.baseBlock());

    @Test
    public void checkToken() {
        IJarvisBot iJarvisBot = jarvisBotLazy.get();
        assertNotNull(iJarvisBot);
    }

    @Test
    public void checkChat() {
        IJarvisBot iJarvisBot = jarvisBotLazy.get();

        List<MessageItem> messageItems = new ArrayList<>();
        MessageUserItem message = new MessageUserItem();
        message.setRole("user");
        message.setContent("hi");
        messageItems.add(message);
        ChatReq chatReq = Chat.defaultChat(messageItems);
        ChatRes result = iJarvisBot.chat(chatReq).blockingGet();
        assertNotNull(result);
    }

    @Test
    public void checkTxt2Img() {
        IJarvisBot iJarvisBot = jarvisBotLazy.get();
        ImgRes result = iJarvisBot.txt2img(Txt2Img.default2Img("a nice dog")).blockingGet();
        assertNotNull(result);
        assertFalse(result.getImages().isEmpty());
    }

    @Test
    public void checkImg2Img() {
        IJarvisBot iJarvisBot = jarvisBotLazy.get();
        ArrayList<String> imgList = new ArrayList<>();
        imgList.add("YOURURL");
        ImgRes result = iJarvisBot.img2img(Img2Img.default2Img("a nice dog", imgList)).blockingGet();
        assertNotNull(result);
        assertFalse(result.getImages().isEmpty());
    }

    @Test
    public void checkAsr() {
        IJarvisBot iJarvisBot = jarvisBotLazy.get();
        String base64String = "";
        try {
            URI uri = getClass().getResource("/response.mp3").toURI();
            Path path = Paths.get(uri);
            byte[] fileBytes = Files.readAllBytes(path);
            base64String = Base64.getEncoder().encodeToString(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AsrRes result = iJarvisBot.asr(Asr.defaultAsr(base64String)).blockingGet();
        assertNotNull(result);
        assertFalse(result.getText().get(0).isEmpty());
    }

    @Test
    public void checkTts() {
        IJarvisBot iJarvisBot = jarvisBotLazy.get();
        byte[] result = iJarvisBot.tts(Tts.defaultTts("i im ok")).blockingGet();
        assertNotNull(result);
        assertNotEquals(0, result.length);
    }


    @Test
    public void checkChatSee() {
        IJarvisBot iJarvisBot = jarvisBotLazy.get();
        List<MessageItem> messageItems = new ArrayList<>();
        MessageUserItem message = new MessageUserItem();
        message.setRole("user");
        message.setContent("how to write markdown?");
        messageItems.add(message);
        Observer<ChatRes> result = iJarvisBot.chatSee(Chat.defaultChat(messageItems));
        result.observeBlock(new Consumer<ChatRes>() {

            @Override
            public void apply(ChatRes param) {
                assertNotNull(param);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                fail();
            }
        });
    }

}
