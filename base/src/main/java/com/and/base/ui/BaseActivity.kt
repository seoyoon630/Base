@file:Suppress("MemberVisibilityCanBePrivate")

package com.and.base.ui

import android.R
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer

abstract class BaseActivity : AppCompatActivity() {

    abstract val vm: BaseViewModel

    lateinit var mContext: Context
    lateinit var mActivity: BaseActivity
    lateinit var mDecor: View

    lateinit var mProgress: Dialog

    protected fun setRequestedOrientation() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
    }

    protected fun setSoftInputMode() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation()
        setSoftInputMode()
        super.onCreate(savedInstanceState)

        mContext = this
        mActivity = this
        mDecor = window.decorView
        mProgress = createProgress()

        // Progress 정의
        vm.isProgress.observe(mActivity, Observer { it?.let { isProgress -> if (isProgress) showProgress(); else dismissProgress() } })
        vm.alertMessage.observe(mActivity, Observer { it?.let { message -> showDialog(message = message, positiveButtonText = "확인") } })
    }

    // Dialog
    fun getDialog(title: Any? = null,
                  message: Any? = null,
                  view: View? = null,
                  positiveButtonText: Any? = null,
                  positiveListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null,
                  negativeButtonText: Any? = null,
                  negativeListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null,
                  neutralButtonText: Any? = null,
                  neutralListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null): AlertDialog? {
        return AlertDialog.Builder(this).apply {
            if (title != null) setTitle(getText(title))
            if (message != null) setMessage(getText(message))
            if (view != null) setView(view)
            if (positiveButtonText != null) setPositiveButton(getText(positiveButtonText), positiveListener)
            if (negativeButtonText != null) setNegativeButton(getText(negativeButtonText), negativeListener)
            if (neutralButtonText != null) setNeutralButton(getText(neutralButtonText), neutralListener)
        }.create()
    }


    fun showDialog(title: Any? = null,
                   message: Any? = null,
                   view: View? = null,
                   positiveButtonText: Any? = null,
                   positiveListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null,
                   negativeButtonText: Any? = null,
                   negativeListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null,
                   neutralButtonText: Any? = null,
                   neutralListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null) {
        val dialog = getDialog(title, message, view, positiveButtonText, positiveListener, negativeButtonText, negativeListener, neutralButtonText, neutralListener)
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            return
        }
        if (isFinishing) {
            return
        }
        dialog?.show()
    }

    protected fun createProgress(): Dialog {
        val dialog = Dialog(mContext)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.window?.apply {
            setContentView(ProgressBar(mContext, null, R.attr.progressBarStyleLarge))
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        return dialog
    }

    fun showProgress() {
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            return
        }
        if (isFinishing) {
            return
        }

        if (mProgress.isShowing) {
            return
        }

        mProgress.show()
    }

    fun dismissProgress() {
        if (mProgress.isShowing) {
            mProgress.dismiss()
        }
    }


    private fun getText(text: Any?): CharSequence? {
        if (text is CharSequence) return text
        return if (text is Int) this.getString(text) else text.toString()
    }


}