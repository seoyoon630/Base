@file:Suppress("PropertyName", "MemberVisibilityCanBePrivate")

package com.and.base.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected val _isProgress = MutableLiveData<Boolean>()
    val isProgress: LiveData<Boolean> get() = _isProgress

    protected val _alertMessage = MutableLiveData<String>()
    val alertMessage: LiveData<String> get() = _alertMessage

}