package es.voghdev.hellokotlin.global

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeDatabase()
    }

    override fun onTerminate() {
        super.onTerminate()

        FlowManager.destroy()
    }

    private fun initializeDatabase() {
        FlowManager.init(this)
    }
}
