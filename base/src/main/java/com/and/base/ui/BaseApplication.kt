package com.and.base.ui

import android.app.Application
import android.webkit.WebView
import com.and.base.component.B
import com.facebook.stetho.Stetho

abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (B.DEBUG) {
            Stetho.initializeWithDefaults(this)
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }
}