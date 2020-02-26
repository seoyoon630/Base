@file:Suppress("ConstantConditionIf")

package com.and.base.ui

import android.app.Application
import android.webkit.WebView
import com.and.base.component.isDebug
import com.facebook.stetho.Stetho

abstract class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (isDebug()) {
            Stetho.initializeWithDefaults(this)
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }
}