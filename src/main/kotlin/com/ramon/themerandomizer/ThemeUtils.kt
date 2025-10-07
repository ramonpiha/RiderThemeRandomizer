package com.ramon.themerandomizer

import com.intellij.ide.ui.LafManager
import com.intellij.ide.ui.laf.UIThemeLookAndFeelInfo
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.colors.EditorColorsManager
import kotlin.random.Random

object ThemeUtils {

    fun randomizeTheme() {
        val lafManager = LafManager.getInstance()
        val themes: List<UIThemeLookAndFeelInfo> = lafManager.installedThemes.toList()

        if (themes.isNotEmpty()) {
            val randomTheme = themes[Random.nextInt(themes.size)]

            ApplicationManager.getApplication().invokeLater {
                // Apply UI theme
                lafManager.setCurrentLookAndFeel(randomTheme, true)
                lafManager.updateUI()

                // Apply the editor color scheme that matches the theme
                applyMatchingEditorScheme(randomTheme)
            }
        }
    }

    private fun applyMatchingEditorScheme(theme: UIThemeLookAndFeelInfo) {
        val editorColorsManager = EditorColorsManager.getInstance()

        // Try to get the editor scheme name from the theme
        val editorSchemeName = theme.editorSchemeId

        if (editorSchemeName != null) {
            val scheme = editorColorsManager.getScheme(editorSchemeName)
            if (scheme != null) {
                editorColorsManager.setGlobalScheme(scheme)
            }
        }
    }
}