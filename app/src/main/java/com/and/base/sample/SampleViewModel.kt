package com.and.base.sample

import com.and.base.ui.BaseViewModel

class SampleViewModel : BaseViewModel() {

    fun alertTest() {
        _alertMessage.postValue("Test")
    }
}
