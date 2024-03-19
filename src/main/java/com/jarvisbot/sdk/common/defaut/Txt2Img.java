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

import com.jarvisbot.sdk.entity.req.Txt2imgReq;
import com.jarvisbot.sdk.entity.req.img2img.AlwaysonScripts;

import java.util.Collections;

public class Txt2Img {

    public static Txt2imgReq default2Img(String prompt) {
        Txt2imgReq req = new Txt2imgReq();
        // no default
        req.setHrCheckpointName(null);
        // no default
        req.setScriptArgs(null);
        // no default
        req.setRefinerCheckpoint(null);
        // no default
        req.setRefinerSwitchAt(null);
        // no default
        req.setHrNegativePrompt(null);
        // no default
        req.setScriptName(null);
        // no default
        req.setFirstphaseHeight(null);
        // no default
        req.setRestoreFaces(null);
        // no default
        req.setComments(null);
        // no default
        req.setHrUpscaler(null);

        // default [""]
        req.setPrompt(prompt);
        // default ""
        req.setNegativePrompt("");
        // default 0
        req.setDenoisingStrength(0F);
        // default "Euler"
        req.setSamplerIndex("Euler");
        // default 7
        req.setCfgScale(7);
        // default 1
        req.setBatchSize(1);
        // default -1
        req.setSeedResizeFromH(-1);
        // default 1
        req.setNIter(1);
        // default -1
        req.setSeedResizeFromW(-1);
        // default 2
        req.setHrScale(2F);
        // default false
        req.setDisableExtraNetworks(false);
        // default 512
        req.setWidth(512);
        req.setHeight(512);
        req.setSendImages(true);
        req.setSaveImages(false);
        req.setAlwaysonScripts(new AlwaysonScripts());
        req.setScriptArgs(Collections.emptyList());
        req.setDoNotSaveGrid(false);
        req.setDoNotSaveSamples(false);
        req.setEnableHr(false);
        req.setFirstphaseHeight(0);
        req.setFirstphaseWidth(0);
        req.setHrNegativePrompt("");
        req.setHrPrompt("");
        req.setHrResizeX(0);
        req.setHrResizeY(0);
        req.setHrSecondPassSteps(0);
        req.setOverrideSettingsRestoreAfterwards(true);
        req.setSeed(-1);
        req.setSubseedStrength(0f);
        req.setTiling(null);
        req.setSubseed(-1L);
        req.setSteps(50);
        return req;
    }

}