package com.wx.compose.plugin

import android.app.Application

class MyApp : Application() {

    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}