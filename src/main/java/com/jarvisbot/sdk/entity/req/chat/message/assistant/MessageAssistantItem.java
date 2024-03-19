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

package com.jarvisbot.sdk.entity.req.chat.message.assistant;

import com.alibaba.fastjson.annotation.JSONField;
import com.jarvisbot.sdk.common.validation.ValueValid;
import com.jarvisbot.sdk.entity.req.chat.message.MessageItem;
import lombok.Data;

import java.util.List;

@Data
@ValueValid
public class MessageAssistantItem implements MessageItem {

    /**
     * [string][null]
     */
    @JSONField(name = "content")
    private String content;

    /**
     * const [assistant]
     */
    @JSONField(name = "role")
    private String role = "assistant";


    @JSONField(name = "tool_calls")
    private List<MessageAssistantToolItem> toolCalls;


    @JSONField(name = "function_call")
    private MessageAssistantFunctionItem functionCall;
}