package com.and.base.log

import com.and.base.ui.BaseApplication
import com.orhanobut.logger.Logger


object Log {

    fun d(message: Any) {
        if (BaseApplication.IS_DEBUG)
            Logger.d(message)
    }

    fun i(message: String) {
        if (BaseApplication.IS_DEBUG)
            Logger.i(message)
    }

    fun w(message: String) {
        if (BaseApplication.IS_DEBUG)
            Logger.w(message)
    }

    fun e(message: String) {
        if (BaseApplication.IS_DEBUG)
            Logger.e(message)
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