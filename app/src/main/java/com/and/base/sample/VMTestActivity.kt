package com.and.base.sample

import com.and.base.ui.BaseActivity
import com.and.base.ui.BaseViewModel

class VMTestActivity : BaseActivity() {

    override val vm: BaseViewModel by lazy { VMTestViewModel() }
}