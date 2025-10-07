package com.ramon.themerandomizer

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.Service
import com.intellij.openapi.application.ApplicationManager

@State(
    name = "ThemeRandomizerSettings",
    storages = [Storage("themeRandomizer.xml")]
)
@Service(Service.Level.APP)
class ThemeRandomizerSettings : PersistentStateComponent<ThemeRandomizerSettings.State> {

    data class State(
        var autoRandomize: Boolean = false,
        var intervalMinutes: Int = 30
    )

    private var state = State()

    override fun getState(): State = state

    override fun loadState(state: State) {
        this.state = state
    }

    companion object {
        fun getInstance(): ThemeRandomizerSettings =
            ApplicationManager.getApplication().getService(ThemeRandomizerSettings::class.java)
    }

    var autoRandomize: Boolean
        get() = state.autoRandomize
        set(value) { state.autoRandomize = value }

    var intervalMinutes: Int
        get() = state.intervalMinutes
        set(value) { state.intervalMinutes = value }
}
