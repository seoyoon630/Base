package com.and.base.component

import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.ApplicationInfo



fun Context.isDebug(): Boolean {
    val isDebug: Boolean
    try {
        val appInfo = packageManager.getApplicationInfo(packageName, 0)
        isDebug = (0 != (appInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE))
    } catch (ne: PackageManager.NameNotFoundException) {
        return false
    }
    return isDebug
}


