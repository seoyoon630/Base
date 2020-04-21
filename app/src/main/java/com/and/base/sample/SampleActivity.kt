package com.and.base.sample

import android.os.Bundle
import com.and.base.component.PP
import com.and.base.log.Log
import com.and.base.ui.BaseActivity

class SampleActivity : BaseActivity() {

    override val vm by lazy { SampleViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
