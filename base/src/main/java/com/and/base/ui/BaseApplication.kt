@file:Suppress("ConstantConditionIf")

package com.and.base.ui

import android.app.Application
import android.webkit.WebView
import com.and.base.component.PP
import com.and.base.component.isDebug
import com.facebook.stetho.Stetho
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

abstract class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        IS_DEBUG = isDebug()

        if (IS_DEBUG) {
            Stetho.initializeWithDefaults(this)
            WebView.setWebContentsDebuggingEnabled(true)
        }
        PP.getInstance(null).CREATE(this@BaseApplication)

        Logger.addLogAdapter(AndroidLogAdapter(initLogOption()))
    }

    companion object {
        var IS_DEBUG = false
    }

    open fun initLogOption(): FormatStrategy {
        return PrettyFormatStrategy.newBuilder().apply {
            showThreadInfo(false)
            methodCount(2)
            tag(applicationInfo.loadLabel(packageManager).toString())
        }.build()
    }
}