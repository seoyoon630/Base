@file:Suppress("MemberVisibilityCanBePrivate")

package com.and.base.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import java.lang.Exception

abstract class BaseFragment : Fragment() {

    abstract val vm: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragment Progress 정의
        vm.isProgress.observe(viewLifecycleOwner, Observer { it?.let { isProgress -> if (isProgress) showProgress(); else dismissProgress() } })
        vm.alertMessage.observe(viewLifecycleOwner, Observer { it?.let { message -> showDialog(message = message, positiveButtonText = "확인") } })

        parseExtra()
        loadOnce()
        reload()
    }

    protected fun parseExtra() {
        try {
            onParseExtra()
        } catch (ignore: Exception) {
        }
    }

    protected fun loadOnce() {
        onLoadOnce()
    }

    protected fun load() {
        onLoad()
    }

    protected fun clear() {
        onClear()
    }

    protected fun reload() {
        onReload()
    }

    protected open fun onParseExtra() {}
    protected open fun onLoadOnce() {}
    protected open fun onReload() {
        clear()
        load()
    }

    protected open fun onClear() {}
    protected open fun onLoad() {}

    fun showProgress() = (requireActivity() as BaseActivity).showProgress()
    fun dismissProgress() = (requireActivity() as BaseActivity).dismissProgress()
    fun showDialog(title: Any? = null,
                   message: Any? = null,
                   view: View? = null,
                   positiveButtonText: Any? = null,
                   positiveListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null,
                   negativeButtonText: Any? = null,
                   negativeListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null,
                   neutralButtonText: Any? = null,
                   neutralListener: ((dialogInterface: DialogInterface, position: Int) -> Unit)? = null) =
            (requireActivity() as BaseActivity).showDialog(title, message, view, positiveButtonText, positiveListener, negativeButtonText, negativeListener, neutralButtonText, neutralListener)

}