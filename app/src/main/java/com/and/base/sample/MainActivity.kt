package com.and.base.sample

import android.os.Bundle
import com.and.base.ui.BaseActivity

class MainActivity : BaseActivity() {

    override val vm by lazy { VMTestViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
