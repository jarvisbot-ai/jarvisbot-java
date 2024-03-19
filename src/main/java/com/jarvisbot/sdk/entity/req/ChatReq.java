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

package com.jarvisbot.sdk.entity.req;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.jarvisbot.sdk.common.validation.ValueValid;
import com.jarvisbot.sdk.entity.req.chat.ChatFun;
import com.jarvisbot.sdk.entity.req.chat.ChatTool;
import com.jarvisbot.sdk.entity.req.chat.ChatFormat;
import com.jarvisbot.sdk.entity.req.chat.message.MessageItem;
import lombok.Data;

@Data
@ValueValid
public class ChatReq {

    /**
     * default null
     * [-100,100]
     * adjusts the likelihood of specific tokens appearing in generated text
     */
    @JSONField(name = "logit_bias")
    private Float logitBias;

    /**
     * null
     * A description of what the function does,
     * used by the model to choose when and how to call the function.
     */
    @Deprecated
    @JSONField(name = "functions")
    private List<ChatFun> functions;

    /**
     * null
     * [number]
     * This feature is in Beta. If specified,
     * our system will make a best effort to
     * sample deterministically, such that
     * repeated requests with the same seed
     * and parameters should return the same result.
     * Determinism is not guaranteed, and you should
     * refer to the system_fingerprint response
     * parameter to monitor changes in the backend.
     */
    @JSONField(name = "seed")
    private Integer seed;

    /**
     * any of [String][Object][null]
     * Controls which (if any) function is called by the model.
     * none means the model will not call a function and instead
     * generates a message. auto means the model can pick between
     * generating a message or calling a function. Specifying a
     * particular function via {"name": "my_function"} forces
     * the model to call that function.
     * none is the default when no functions are present.
     * auto is the default if functions are present.
     * Deprecated in favor of tool_choice
     */
    @Deprecated
    @JSONField(name = "function_call")
    private Object functionCall;

    /**
     * default 0
     * [-2,2]
     * Positive values penalize new tokens based on whether they appear
     * in the text so far, increasing the model's likelihood to talk
     * about new topics.
     */
    @JSONField(name = "presence_penalty")
    private Float presencePenalty;

    /**
     * null
     * A list of tools the model may call.
     * Currently, only functions are supported as a tool.
     * Use this to provide a list of functions the model may generate JSON inputs for.
     */
    @JSONField(name = "tools")
    private List<ChatTool> tools;

    /**
     * default 0
     * 0 disable
     * Enable Mirostat constant-perplexity algorithm
     * of the specified version (1 or 2; 0 = disabled)
     * [1][2][0]
     */
    @JSONField(name = "mirostat_mode")
    private Integer mirostatMode;

    /**
     * default 0.95
     * [0,1]
     * Limit the next token selection to a subset of
     * tokens with a cumulative probability above a threshold P.
     * Top-p sampling, also known as nucleus sampling,
     * is another text generation method that selects the
     * next token from a subset of tokens that together
     * have a cumulative probability of at least p. This method
     * provides a balance between diversity and quality by
     * considering both the probabilities of tokens and the
     * number of tokens to sample from. A higher value
     * for top_p (e.g., 0.95) will lead to more diverse text,
     * while a lower value (e.g., 0.5) will generate more
     * focused and conservative text.
     */
    @JSONField(name = "top_p")
    private Float topP;

    /**
     * null
     * default 0
     * [-2,2]
     * Positive values penalize new tokens based on their
     * existing frequency in the text so far, decreasing
     * the model's likelihood to repeat the same line verbatim.
     */
    @JSONField(name = "frequency_penalty")
    private Float frequencyPenalty;

    /**
     * null
     * Setting to { "type": "json_object" } enables JSON mode,
     * which guarantees the message the model generates is valid JSON.
     * Important: when using JSON mode, you must also instruct the model
     * to produce JSON yourself via a system or user message. Without this,
     * the model may generate an unending stream of whitespace until the
     * generation reaches the token limit, resulting in a long-running
     * and seemingly "stuck" request. Also note that the message content
     * may be partially cut off if finish_reason="length", which indicates
     * the generation exceeded max_tokens or the conversation exceeded the
     * max context length.
     */
    @JSONField(name = "response_format")
    private ChatFormat responseFormat;

    /**
     * null
     */
    @JSONField(name = "grammar")
    private String grammar;

    /**
     * default false
     * Whether to stream the results as they
     * are generated. Useful for chatbots.
     */
    @JSONField(name = "stream")
    private Boolean stream;

    /**
     * default 40
     * [>=0]
     * Limit the next token selection to the K most probable tokens.
     * Top-k sampling is a text generation method that selects the
     * next token only from the top k most likely tokens predicted
     * by the model. It helps reduce the risk of generating
     * low-probability or nonsensical tokens, but it may also
     * limit the diversity of the output. A higher value for
     * top_k (e.g., 100) will consider more tokens and lead to
     * more diverse text, while a lower value (e.g., 10) will
     * focus on the most probable tokens and generate more conservative text.
     */
    @JSONField(name = "top_k")
    private Integer topK;

    /**
     * default 0.8
     * [0,2]
     * Adjust the randomness of the generated text.
     * Temperature is a hyperparameter that controls
     * the randomness of the generated text. It affects
     * the probability distribution of the model's output
     * tokens. A higher temperature (e.g., 1.5) makes the
     * output more random and creative, while a lower
     * temperature (e.g., 0.5) makes the output more focused,
     * deterministic, and conservative. The default value is 0.8,
     * which provides a balance between randomness and determinism.
     * At the extreme, a temperature of 0 will always pick the most
     * likely next token, leading to identical outputs in each run.
     */
    @JSONField(name = "temperature")
    private Float temperature;

    /**
     * any of [string:"none"][object:{@link ChatTool}][null]
     * Controls which (if any) function is called by the model.
     * none means the model will not call a function and instead
     * generates a message. auto means the model can pick between
     * generating a message or calling a function. Specifying a
     * particular function via {"type": "function", "function": {"name": "my_function"}}
     * forces the model to call that function.
     * none is the default when no functions are present.
     * auto is the default if functions are present.
     */
    @JSONField(name = "tool_choice")
    private Object toolChoice;

    /**
     * [string][null]
     * The model to use for generating completions.
     * example:"gpt-3.5-turbo-0125"
     */
    @JSONField(name = "model")
    private String model;

    /**
     * null
     * [input_ids][tokens]
     */
    @JSONField(name = "logit_bias_type")
    private String logitBiasType;

    /**
     * default 0.1
     * [0.001,1]
     */
    @JSONField(name = "mirostat_eta")
    private Float mirostatEta;

    /**
     * The maximum number of tokens to generate. Defaults to inf
     */
    @JSONField(name = "max_tokens")
    private Integer maxTokens;

    /**
     * default 1
     * [integer][null]
     */
    @JSONField(name = "n")
    private Integer n;

    /**
     * default 0.05
     * Sets a minimum base probability threshold for token selection.
     * The Min-P sampling method was designed as an alternative to
     * Top-P, and aims to ensure a balance of quality and variety.
     * The parameter min_p represents the minimum probability for
     * a token to be considered, relative to the probability of the
     * most likely token. For example, with min_p=0.05 and the most
     * likely token having a probability of 0.9, logits with a value
     * less than 0.045 are filtered out.
     */
    @JSONField(name = "min_p")
    private Float minP;

    /**
     * [string][array<string>][null]
     * A list of tokens at which to stop generation. If None, no stop tokens are used.
     */
    @JSONField(name = "stop")
    private Object stop;

    /**
     * default 5
     * [0,10]
     * Mirostat target entropy, i.e. the target perplexity -
     * lower values produce focused and coherent text, larger
     * values produce more diverse and less coherent text
     */
    @JSONField(name = "mirostat_tau")
    private Float mirostatTau;

    /**
     * default 1.1
     * [>=0]
     * A penalty applied to each token that is already generated.
     * This helps prevent the model from repeating itself.
     * Repeat penalty is a hyperparameter used to penalize the
     * repetition of token sequences during text generation. It
     * helps prevent the model from generating repetitive or
     * monotonous text. A higher value (e.g., 1.5) will penalize
     * repetitions more strongly, while a lower value (e.g., 0.9)
     * will be more lenient.
     */
    @JSONField(name = "repeat_penalty")
    private Float repeatPenalty;

    /**
     * default []
     * A list of messages to generate completions for.
     */
    @JSONField(name = "messages")
    private List<MessageItem> messages;

    /**
     * [string][null]
     * A unique identifier representing your end-user,
     * which can help OpenAI to monitor and detect abuse. Learn more.
     */
    @JSONField(name = "user")
    private String user;

}