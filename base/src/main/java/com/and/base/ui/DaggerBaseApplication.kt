@file:Suppress("ConstantConditionIf")

package com.and.base.ui

import android.webkit.WebView
import com.and.base.component.PP
import com.and.base.component.getLabel
import com.and.base.component.isDebug
import com.facebook.stetho.Stetho
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.android.DaggerApplication

abstract class DaggerBaseApplication : DaggerApplication() {


    override fun onCreate() {
        super.onCreate()
        IS_DEBUG = isDebug()

        if (IS_DEBUG) {
            Stetho.initializeWithDefaults(this)
            WebView.setWebContentsDebuggingEnabled(true)
        }
        PP.CREATE(this@DaggerBaseApplication)

        Logger.addLogAdapter(AndroidLogAdapter(initLogOption()))
    }

    companion object {
        var IS_DEBUG = false
    }

    open fun initLogOption(): FormatStrategy {
        return PrettyFormatStrategy.newBuilder().apply {
            showThreadInfo(false)
            methodCount(2)
            tag(getLabel())
        }.build()
    }
}