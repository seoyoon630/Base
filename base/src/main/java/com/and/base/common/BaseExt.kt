package com.and.base.common

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RawRes

fun View.showKeyboard() {
    this.requestFocus()
    val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Context.dp2px(dp: Float): Int {
    val display_metrics: DisplayMetrics = resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, display_metrics).toInt()
}

fun Context.sp2px(sp: Float): Int {
    val display_metrics: DisplayMetrics = resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, display_metrics).toInt()
}

fun Context.raw2String(@RawRes rawResId: Int) : String? {
    return try {
        val inputStream = resources.openRawResource(rawResId)
        val b = ByteArray(inputStream.available())
        inputStream.read(b)
        inputStream.close()
        String(b)
    } catch (e: Exception) {
        null
    }
}