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

import com.jarvisbot.sdk.entity.req.Img2imgReq;
import com.jarvisbot.sdk.entity.req.img2img.AlwaysonScripts;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Img2Img {

    public static Img2imgReq default2Img(String prompt, List<String> imgList) {
        Img2imgReq req = new Img2imgReq();
        // no default
        req.setInitialNoiseMultiplier(null);
        // no default
        req.setSMinUncond(null);
        // no default
        req.setSTmin(null);
        // no default
        req.setSNoise(null);
        // no default
        req.setTiling(null);
        // no default
        req.setSChurn(null);
        // no default
        req.setSTmax(null);
        // no default
        req.setOverrideSettings(null);
        // no default
        req.setSamplerName(null);
        // no default
        req.setAlwaysonScripts(null);
        // no default
        req.setLatentMask(null);
        // no default
        req.setStyles(null);
        // no default
        req.setMaskBlur(null);
        // no default
        req.setImageCfgScale(null);
        // no default
        req.setInitImages(imgList.stream().map(string -> (Object) string).collect(Collectors.toList()));
        // no default
        req.setScriptArgs(Collections.emptyList());
        // no default
        req.setComments(null);
        // no default
        req.setRestoreFaces(null);
        // no default
        req.setScriptName(null);
        // no default
        req.setRefinerCheckpoint(null);
        // no default
        req.setRefinerSwitchAt(null);

        // default true
        req.setOverrideSettingsRestoreAfterwards(true);
        // default null
        req.setEta(null);
        // default 0
        req.setInpaintingMaskInvert(0);
        // default -1
        req.setSubseed(-1);
        // default 512
        req.setHeight(512);
        // default 0
        req.setResizeMode(0);
        // default false
        req.setDoNotSaveSamples(false);
        // default 50
        req.setSteps(50);
        // default 4
        req.setMaskBlurX(4);
        // default 0
        req.setSubseedStrength(0F);
        // default 0
        req.setInpaintFullResPadding(0);
        // default 4
        req.setMaskBlurY(4);
        // default false
        req.setDoNotSaveGrid(false);
        // default -1
        req.setSeed(-1);
        // default false
        req.setSaveImages(false);
        // default true
        req.setSendImages(true);
        // default ""
        req.setNegativePrompt("");
        // default 0
        req.setInpaintingFill(0);
        // default "Euler"
        req.setSamplerIndex("Euler");
        // default 7
        req.setCfgScale(7);
        // no default
        req.setMask(null);
        // default 1
        req.setBatchSize(1);
        // default -1
        req.setSeedResizeFromH(-1);
        // default true
        req.setInpaintFullRes(true);
        // default false
        req.setIncludeInitImages(false);
        // default 1
        req.setNIter(1);
        // default -1
        req.setSeedResizeFromW(-1);
        // default false
        req.setDisableExtraNetworks(false);
        // default 512
        req.setWidth(512);
        // default ""
        req.setPrompt(prompt);
        req.setAlwaysonScripts(new AlwaysonScripts());
        req.setDenoisingStrength(0.75F);
        return req;
    }
}