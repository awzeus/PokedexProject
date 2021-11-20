package com.awzeus.openpokedex

import android.app.Application
import com.awzeus.openpokedex.data.local.database.DatabaseManager

open class PokedexApplication: Application() {
    override fun onCreate() {
        DatabaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}