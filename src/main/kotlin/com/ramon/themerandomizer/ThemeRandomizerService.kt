package com.ramon.themerandomizer

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service
import com.intellij.util.concurrency.AppExecutorUtil
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

@Service(Service.Level.APP)
class ThemeRandomizerService {

    private var scheduledTask: ScheduledFuture<*>? = null
    private val settings = ThemeRandomizerSettings.getInstance()

    init {
        scheduleThemeRandomization()
    }

    fun scheduleThemeRandomization() {
        // Cancel existing task if any
        scheduledTask?.cancel(false)

        if (settings.autoRandomize) {
            val intervalMillis = settings.intervalMinutes * 60 * 1000L

            scheduledTask = AppExecutorUtil.getAppScheduledExecutorService().scheduleWithFixedDelay(
                { ThemeUtils.randomizeTheme() },
                intervalMillis,
                intervalMillis,
                TimeUnit.MILLISECONDS
            )
        }
    }

    companion object {
        fun getInstance(): ThemeRandomizerService =
            ApplicationManager.getApplication().getService(ThemeRandomizerService::class.java)
    }
}