package com.and.base.component

import android.os.Looper
import java.util.Observable

class EventObserver private constructor() : Observable() {
    companion object {
        private val instance = EventObserver()
        fun getInstance() = instance
        fun notify(obj: EE) = getInstance().notifyObservers(obj)
    }

    override fun notifyObservers(arg: Any?) {
        if (arg == null)
            throw NullPointerException("!event obj must not null")

        if (arg !is Enum<*>)
            throw NullPointerException("!event obj must Enum")

        if (Looper.myLooper() != Looper.getMainLooper())
            throw NullPointerException("!event obj must be in MainThread")

        setChanged()
        super.notifyObservers(arg)
    }
}