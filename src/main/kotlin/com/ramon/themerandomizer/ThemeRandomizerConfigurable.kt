package com.ramon.themerandomizer

import com.intellij.openapi.options.Configurable
import javax.swing.*
import java.awt.BorderLayout
import java.awt.GridLayout

class ThemeRandomizerConfigurable : Configurable {

    private var mainPanel: JPanel? = null
    private var enableAutoRandomize: JCheckBox? = null
    private var enableDarkThemes: JCheckBox? = null
    private var enableLightThemes: JCheckBox? = null
    private var intervalSpinner: JSpinner? = null

    private val settings = ThemeRandomizerSettings.getInstance()

    override fun getDisplayName(): String = "Theme Randomizer"

    override fun createComponent(): JComponent {
        if (mainPanel == null) {
            mainPanel = JPanel(BorderLayout())
            val settingsPanel = JPanel(GridLayout(0, 2, 10, 10))

            enableAutoRandomize = JCheckBox("Enable Auto-Randomization")
            enableDarkThemes = JCheckBox("Enable Dark Themes")
            enableLightThemes = JCheckBox("Enable Light Themes")
            intervalSpinner = JSpinner(SpinnerNumberModel(settings.intervalMinutes, 1, 1440, 1))

            settingsPanel.add(JLabel("Auto-randomize themes:"))
            settingsPanel.add(enableAutoRandomize)
            settingsPanel.add(JLabel("Dark themes:"))
            settingsPanel.add(enableDarkThemes)
            settingsPanel.add(JLabel("Light themes:"))
            settingsPanel.add(enableLightThemes)
            settingsPanel.add(JLabel("Interval (minutes):"))
            settingsPanel.add(intervalSpinner)

            mainPanel!!.add(settingsPanel, BorderLayout.NORTH)
        }
        reset()
        return mainPanel!!
    }

    override fun isModified(): Boolean {
        val uiAuto = enableAutoRandomize?.isSelected ?: false
        val uiDark = enableDarkThemes?.isSelected ?: false
        val uiLight = enableLightThemes?.isSelected ?: false
        val uiInterval = intervalSpinner?.value as? Int ?: settings.intervalMinutes

        return uiAuto != settings.autoRandomize ||
                uiDark != settings.darkThemes ||
                uiLight != settings.lightThemes ||
                uiInterval != settings.intervalMinutes
    }

    override fun apply() {
        settings.autoRandomize = enableAutoRandomize?.isSelected ?: false
        settings.darkThemes = enableDarkThemes?.isSelected ?: false
        settings.lightThemes = enableLightThemes?.isSelected ?: false
        settings.intervalMinutes = intervalSpinner?.value as? Int ?: settings.intervalMinutes

        // Reschedule the task with new settings
        ThemeRandomizerService.getInstance().scheduleThemeRandomization()
    }

    override fun reset() {
        enableAutoRandomize?.isSelected = settings.autoRandomize
        enableDarkThemes?.isSelected = settings.darkThemes
        enableLightThemes?.isSelected = settings.lightThemes
        intervalSpinner?.value = settings.intervalMinutes
    }

    override fun disposeUIResources() {
        mainPanel = null
        enableAutoRandomize = null
        enableDarkThemes = null
        enableLightThemes = null
        intervalSpinner = null
    }
}
