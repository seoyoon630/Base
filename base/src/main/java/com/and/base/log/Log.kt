package com.and.base.log

import com.and.base.ui.BaseApplication
import com.orhanobut.logger.Logger

object Log {

    fun d(message: Any) {
        if (BaseApplication.IS_DEBUG)
            Logger.d(message)
    }

    fun i(message: Any) {
        if (BaseApplication.IS_DEBUG)
            Logger.i(message.toString())
    }

    fun w(message: Any) {
        if (BaseApplication.IS_DEBUG)
            Logger.w(message.toString())
    }

    fun e(message: Any) {
        if (BaseApplication.IS_DEBUG)
            Logger.e(message.toString())
    }

    fun e(throwable: Throwable, message: Any) {
        if (BaseApplication.IS_DEBUG)
            Logger.e(throwable, message.toString())
    }

    fun json(json: String) {
        if (BaseApplication.IS_DEBUG)
            Logger.json(json)
    }

    fun xml(xml: String) {
        if (BaseApplication.IS_DEBUG)
            Logger.xml(xml)
    }
}