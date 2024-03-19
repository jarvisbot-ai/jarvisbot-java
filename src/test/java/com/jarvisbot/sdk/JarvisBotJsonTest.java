package com.jarvisbot.sdk;

import com.jarvisbot.sdk.entity.res.AsrRes;

import cn.hutool.core.io.resource.ResourceUtil;
import com.jarvisbot.sdk.entity.res.ChatRes;

import com.jarvisbot.sdk.common.utils.JsonUtils;
import com.jarvisbot.sdk.entity.res.ImgRes;

import com.jarvisbot.sdk.entity.res.Res422;
import com.jarvisbot.sdk.entity.res.chat.DetailItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test whether each json data structure is completely correct
 * Test whether each json data structure is completely correct
 */
public class JarvisBotJsonTest {

    @Test
    public void checkRes422() {
        String jsonStr = ResourceUtil.readUtf8Str("422.json");
        Res422 res422 = JsonUtils.parseData(jsonStr, Res422.class);
        assertNotNull(res422);
        List<DetailItem> items = res422.getDetail();
        assertNotNull(items);
        assertFalse(items.isEmpty());
        DetailItem item = items.get(0);
        assertNotNull(item);
        assertNotNull(item.getMsg());
        assertNotNull(item.getType());
        assertNotNull(item.getLoc());
        assertEquals(item.getLoc().get(0), "string");
        assertEquals(item.getLoc().get(1), "0");
    }

    @Test
    public void checkImgRes() {
        String jsonStr = ResourceUtil.readUtf8Str("imgRes.json");
        ImgRes imgRes = JsonUtils.parseData(jsonStr, ImgRes.class);
        assertNotNull(imgRes);
        assertNotNull(imgRes.getImages());
        assertNotNull(imgRes.getParameters());
        assertNotNull(imgRes.getInfo());
        assertNotEquals(new ArrayList<>(), imgRes.getImages());
    }

    @Test
    public void checkTxt2ImgRes() {
        String jsonStr = ResourceUtil.readUtf8Str("txt2ImgRes.json");
        ImgRes imgRes = JsonUtils.parseData(jsonStr, ImgRes.class);
        assertNotNull(imgRes);
        assertNotNull(imgRes.getImages());
        assertNotNull(imgRes.getParameters());
        assertNotNull(imgRes.getInfo());
        assertNotEquals(new ArrayList<>(), imgRes.getImages());
    }

    @Test
    public void checkTxt2Txt() {
        String jsonStr = ResourceUtil.readUtf8Str("txt2txt.json");
        ChatRes chatRes = JsonUtils.parseData(jsonStr, ChatRes.class);
        assertEquals("1709798522", chatRes.getCreated());

        assertEquals("53", chatRes.getUsage().getTotalTokens());
        assertEquals("33", chatRes.getUsage().getPromptTokens());
        assertEquals("20", chatRes.getUsage().getCompletionTokens());

        assertEquals("/local/llm_models/llama-2-7b-chat.Q4_K_M.gguf", chatRes.getModel());

        assertEquals("chatcmpl-82145f33-287b-4767-afb9-37226ef33c6a", chatRes.getId());

        assertEquals("0", chatRes.getChoices().get(0).getIndex());
        assertEquals("  Of course! The capital of France is Paris. \uD83C\uDDEB\uD83C\uDDF7", chatRes.getChoices().get(0).getMessage().getContent());
        assertEquals("assistant", chatRes.getChoices().get(0).getMessage().getRole());

        assertEquals("chat.completion", chatRes.getObject());
    }

    @Test
    public void checkAsrRes() {
        String jsonStr = ResourceUtil.readUtf8Str("asrRes.json");
        AsrRes asrRes = JsonUtils.parseData(jsonStr, AsrRes.class);
        assertEquals("", asrRes.getId());
        assertEquals("asr", asrRes.getObject());
        assertEquals("1709794298", asrRes.getCreated());
        assertEquals("", asrRes.getMessage());
        assertEquals(" Hi, I'm Longking Chao.\n", asrRes.getText().get(0));
    }


}
