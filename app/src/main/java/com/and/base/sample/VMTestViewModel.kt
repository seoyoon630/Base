package com.and.base.sample

import com.and.base.ui.BaseViewModel

class VMTestViewModel : BaseViewModel() {

    fun alertTest() {
        _alertMessage.postValue("Test")
    }
}
