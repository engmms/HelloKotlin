package es.voghdev.hellokotlin.global

import com.raizlabs.android.dbflow.annotation.Database
import es.voghdev.hellokotlin.global.AppDatabase.Companion.NAME
import es.voghdev.hellokotlin.global.AppDatabase.Companion.VERSION

@Database(name = NAME, version = VERSION)
class AppDatabase {
    companion object {
        const val NAME = "AppDatabase.db"
        const val VERSION = 1
    }
}