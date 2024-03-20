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
import com.jarvisbot.sdk.entity.req.txt2img.OverrideSettings;
import lombok.Data;

@Data
@ValueValid
public class Txt2imgReq {

    /**
     * default 0.0
     * [0.0,15.0 step 0.01]
     * Negative Guidance minimum sigma
     */
    @JSONField(name = "s_min_uncond")
    private Float sMinUncond;

    /**
     * default 0.0
     * sigma tmin
     * [0,10 step 0.01]
     * enable stochasticity; start value of the sigma range; only applies to Euler, Heun, and DPM2
     */
    @JSONField(name = "s_tmin")
    private Float sTmin;

    /**
     * default true
     * Used to determine whether the original settings need
     * to be restored after performing an image processing.
     */
    @JSONField(name = "override_settings_restore_afterwards")
    private Boolean overrideSettingsRestoreAfterwards;

    /**
     * default 1.0
     * sigma noise
     * [0.0,1.1 step 0.001]
     * amount of additional noise to counteract loss of detail during sampling
     */
    @JSONField(name = "s_noise")
    private Float sNoise;

    /**
     * default false
     * produce a tileable picture
     */
    @JSONField(name = "tiling")
    private Boolean tiling;

    /**
     * default null
     * sampler name used in high resolution mode
     */
    @JSONField(name = "hr_sampler_name")
    private String hrSamplerName;

    /**
     * default 0.0
     * sigma churn
     * [0,100 step 0.01]
     * amount of stochasticity; only applies to Euler, Heun, and DPM2
     */
    @JSONField(name = "s_churn")
    private Float sChurn;

    /**
     * default 0.0
     * sigma tmax
     * [0,999 step 0.01]
     * 0 = inf; end value of the sigma range; only applies to Euler, Heun, and DPM2
     */
    @JSONField(name = "s_tmax")
    private Float sTmax;

    /**
     * default 0
     * estimated time remaining
     */
    @JSONField(name = "eta")
    private Float eta;

    @JSONField(name = "override_settings")
    private OverrideSettings overrideSettings;

    @JSONField(name = "sampler_name")
    private String samplerName;

    /**
     * default 0
     * [0.2048,step 8]
     * Resize height to txt2img_hr_resize_y
     */
    @JSONField(name = "hr_resize_y")
    private Integer hrResizeY;

    /**
     * default 0
     * [0.2048,step 8]
     * Resize height to txt2img_hr_resize_x
     */
    @JSONField(name = "hr_resize_x")
    private Integer hrResizeX;

    /**
     * This is an array that is empty
     */
    @JSONField(name = "alwayson_scripts")
    private AlwaysonScripts alwaysonScripts;

    /**
     * default -1
     * Variation seed
     * [0,4294967294]
     */
    @JSONField(name = "subseed")
    private Long subseed;

    /**
     * default 512
     * jpg\jpeg <65536
     * webp < 16383
     */
    @JSONField(name = "height")
    private Integer height;

    /**
     * default false
     * Used to determine whether high resolution is enabled
     */
    @JSONField(name = "enable_hr")
    private Boolean enableHr;

    /**
     * default ""
     * prompt at high resolution
     */
    @JSONField(name = "hr_prompt")
    private String hrPrompt;

    /**
     * default false
     * Used to control whether to save the generated sample
     */
    @JSONField(name = "do_not_save_samples")
    private Boolean doNotSaveSamples;

    /**
     * default 50
     * Number of iteration steps
     * No specific iteration range
     */
    @JSONField(name = "steps")
    private Integer steps;

    /**
     * default 0
     * [0,1 step 0.01]
     */
    @JSONField(name = "subseed_strength")
    private Float subseedStrength;

    /**
     * default 0
     * These values determine the size of the image.
     * If these values are set to 0, the system may use the default or preset resolution.
     */
    @JSONField(name = "firstphase_width")
    private Integer firstphaseWidth;

    /**
     * [{@link List<String>}]
     * style
     */
    @JSONField(name = "styles")
    private List<String> styles;

    /**
     * default false
     * Whether to save the image of the grid. Generally, the API is set to False.
     */
    @JSONField(name = "do_not_save_grid")
    private Boolean doNotSaveGrid;

    /**
     * default -1
     * Variation seed
     * [0,4294967294]
     */
    @JSONField(name = "seed")
    private Integer seed;

    /**
     * default false
     * Whether to save the generated image. Generally, the API is set to False.
     */
    @JSONField(name = "save_images")
    private Boolean saveImages;

    /**
     * default true
     * Whether to return the generated image in the response
     */
    @JSONField(name = "send_images")
    private Boolean sendImages;

    /**
     * default 0
     * The number of iteration steps corresponds to the Hires steps of webui.
     */
    @JSONField(name = "hr_second_pass_steps")
    private Integer hrSecondPassSteps;

    /**
     * default ""
     * negative cue words
     */
    @JSONField(name = "negative_prompt")
    private String negativePrompt;

    /**
     * default 0
     * denoise intensity
     * [0,1.0 step 0.01]
     */
    @JSONField(name = "denoising_strength")
    private Float denoisingStrength;

    /**
     * default null
     * null
     */
    @JSONField(name = "hr_upscaler")
    private String hrUpscaler;

    /**
     * default "Euler"
     * null
     */
    @JSONField(name = "sampler_index")
    private String samplerIndex;

    /**
     * default null
     * Large model nickname used in high resolution mode。
     */
    @JSONField(name = "hr_checkpoint_name")
    private String hrCheckpointName;

    @JSONField(name = "script_args")
    private List<Object> scriptArgs;

    /**
     * default 7
     * [1,30 step 0.5]
     */
    @JSONField(name = "cfg_scale")
    private Integer cfgScale;

    /**
     * default 1
     * amount
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

    @JSONField(name = "firstphase_height")
    private Integer firstphaseHeight;

    /**
     * default 2
     * gain
     */
    @JSONField(name = "hr_scale")
    private Float hrScale;

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

    /**
     * null
     */
    @JSONField(name = "refiner_checkpoint")
    private String refinerCheckpoint;

    /**
     * default null
     * [0.01,1 step 0.01]
     */
    @JSONField(name = "refiner_switch_at")
    private Float refinerSwitchAt;

    /**
     * reverse cue word name used in high resolution mode。
     * null
     */
    @JSONField(name = "hr_negative_prompt")
    private String hrNegativePrompt;

    /**
     * default [""]
     */
    @JSONField(name = "prompt")
    private String prompt;
}