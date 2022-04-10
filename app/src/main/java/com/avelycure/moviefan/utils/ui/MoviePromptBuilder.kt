package com.avelycure.moviefan.utils.ui

import android.app.Activity
import uk.co.samuelwall.materialtaptargetprompt.ActivityResourceFinder
import uk.co.samuelwall.materialtaptargetprompt.ResourceFinder
import uk.co.samuelwall.materialtaptargetprompt.extras.PromptOptions
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt

class MoviePromptBuilder (resourceFinder: ResourceFinder) :
    PromptOptions<MoviePromptBuilder>(resourceFinder) {

    private var key: String? = null

    constructor(activity: Activity) : this(ActivityResourceFinder(activity)) {}

    fun setPreferenceKey(key: String?): MoviePromptBuilder {
        this.key = key
        return this
    }

    override fun create(): MaterialTapTargetPrompt? {
        val sharedPreferences = this.resourceFinder
            .context
            .getSharedPreferences("preferences", 0)
        var prompt: MaterialTapTargetPrompt? = null

        if (key == null || !sharedPreferences.getBoolean(key, false)) {
            prompt = super.create()

            if (prompt != null && key != null) {
                sharedPreferences.edit().putBoolean(key, true).apply()
            }
        }
        return prompt
    }
}