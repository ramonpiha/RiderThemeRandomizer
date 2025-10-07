package com.ramon.themerandomizer

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class RandomizeThemeAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        ThemeUtils.randomizeTheme()
    }
}