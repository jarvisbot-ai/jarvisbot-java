/*
 * Copyright 2024 JarvisBot.ai. All rights reserved.
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
import com.jarvisbot.sdk.entity.req.img2img.AlwaysonScripts;
import com.jarvisbot.sdk.entity.req.txt2img.Comments;
import lombok.Data;

@Data
@ValueValid
public class Img2imgReq {

    @JSONField(name = "initial_noise_multiplier")
    private Float initialNoiseMultiplier;

    @JSONField(name = "s_min_uncond")
    private Float sMinUncond;

    @JSONField(name = "s_tmin")
    private Float sTmin;

    /**
     * default true
     */
    @JSONField(name = "override_settings_restore_afterwards")
    private Boolean overrideSettingsRestoreAfterwards;

    @JSONField(name = "s_noise")
    private Float sNoise;

    @JSONField(name = "tiling")
    private Boolean tiling;

    @JSONField(name = "s_churn")
    private Float sChurn;

    /**
     * default 0
     */
    @JSONField(name = "inpainting_mask_invert")
    private int inpaintingMaskInvert;

    @JSONField(name = "s_tmax")
    private Float sTmax;

    @JSONField(name = "eta")
    private Float eta;

    @JSONField(name = "override_settings")
    private Object overrideSettings;

    @JSONField(name = "sampler_name")
    private String samplerName;

    @JSONField(name = "alwayson_scripts")
    private AlwaysonScripts alwaysonScripts;

    /**
     * default -1
     */
    @JSONField(name = "subseed")
    private Integer subseed;

    /**
     * default 512
     */
    @JSONField(name = "height")
    private Integer height;

    /**
     * default 0
     */
    @JSONField(name = "resize_mode")
    private Integer resizeMode;

    /**
     * default false
     */
    @JSONField(name = "do_not_save_samples")
    private Boolean doNotSaveSamples;

    @JSONField(name = "latent_mask")
    private String latentMask;

    /**
     * default 50
     */
    @JSONField(name = "steps")
    private Integer steps;

    /**
     * default 4
     */
    @JSONField(name = "mask_blur_x")
    private Integer maskBlurX;

    /**
     * default 0
     */
    @JSONField(name = "subseed_strength")
    private Float subseedStrength;

    /**
     * default 0
     */
    @JSONField(name = "inpaint_full_res_padding")
    private Integer inpaintFullResPadding;

    /**
     * default 4
     */
    @JSONField(name = "mask_blur_y")
    private Integer maskBlurY;

    /**
     * [{@link List<String>}]
     */
    @JSONField(name = "styles")
    private List<String> styles;

    @JSONField(name = "mask_blur")
    private Integer maskBlur;

    /**
     * default false
     */
    @JSONField(name = "do_not_save_grid")
    private Boolean doNotSaveGrid;

    @JSONField(name = "image_cfg_scale")
    private Float imageCfgScale;

    /**
     * default -1
     */
    @JSONField(name = "seed")
    private Integer seed;

    /**
     * default false
     */
    @JSONField(name = "save_images")
    private Boolean saveImages;

    @JSONField(name = "init_images")
    private List<Object> initImages;

    /**
     * default true
     */
    @JSONField(name = "send_images")
    private Boolean sendImages;

    /**
     * default ""
     */
    @JSONField(name = "negative_prompt")
    private String negativePrompt;

    @JSONField(name = "denoising_strength")
    private Object denoisingStrength;

    /**
     * default 0
     */
    @JSONField(name = "inpainting_fill")
    private Integer inpaintingFill;

    /**
     * default "Euler"
     */
    @JSONField(name = "sampler_index")
    private String samplerIndex;

    @JSONField(name = "script_args")
    private List<Object> scriptArgs;

    /**
     * default 7
     */
    @JSONField(name = "cfg_scale")
    private Integer cfgScale;

    @JSONField(name = "mask")
    private String mask;

    /**
     * default 1
     */
    @JSONField(name = "batch_size")
    private Integer batchSize;

    @JSONField(name = "comments")
    private Comments comments;

    /**
     * default -1
     */
    @JSONField(name = "seed_resize_from_h")
    private Integer seedResizeFromH;

    @JSONField(name = "restore_faces")
    private Boolean restoreFaces;

    /**
     * default true
     */
    @JSONField(name = "inpaint_full_res")
    private Boolean inpaintFullRes;

    /**
     * default false
     */
    @JSONField(name = "include_init_images")
    private Boolean includeInitImages;

    /**
     * default 1
     */
    @JSONField(name = "n_iter")
    private Integer nIter;

    /**
     * default -1
     */
    @JSONField(name = "seed_resize_from_w")
    private Integer seedResizeFromW;

    @JSONField(name = "script_name")
    private String scriptName;

    /**
     * default false
     */
    @JSONField(name = "disable_extra_networks")
    private Boolean disableExtraNetworks;

    /**
     * default 512
     */
    @JSONField(name = "width")
    private Integer width;

    @JSONField(name = "refiner_checkpoint")
    private String refinerCheckpoint;

    @JSONField(name = "refiner_switch_at")
    private Float refinerSwitchAt;

    /**
     * default ""
     */
    @JSONField(name = "prompt")
    private String prompt;
}