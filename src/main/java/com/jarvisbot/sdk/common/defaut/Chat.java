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

package com.jarvisbot.sdk.common.defaut;

import com.jarvisbot.sdk.entity.req.chat.message.MessageItem;

import com.jarvisbot.sdk.entity.req.ChatReq;
import com.jarvisbot.sdk.entity.req.chat.message.user.MessageUserItem;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    public static ChatReq defaultChat(String message) {
        ChatReq req = new ChatReq();
        List<MessageItem> list = new ArrayList<>();
        MessageUserItem item = new MessageUserItem();
        item.setRole("user");
        item.setContent(message);
        list.add(item);
        req.setMessages(list);
        return req;
    }

    public static ChatReq defaultChat(List<MessageItem> messageItems) {
        ChatReq req = new ChatReq();
        req.setMessages(messageItems);
        return req;
    }

}
