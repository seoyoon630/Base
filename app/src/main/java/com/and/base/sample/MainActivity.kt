package com.and.base.sample

import android.os.Bundle
import android.util.Log
import com.and.base.component.PP
import com.and.base.ui.BaseActivity

class MainActivity : BaseActivity() {

    override val vm by lazy { VMTestViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testPP()
    }

    fun testPP(){
        PP.getInstance(PreferenceKeys.Boolean).set(true)
        PP.getInstance(PreferenceKeys.Float).set(0f)
        PP.getInstance(PreferenceKeys.Int).set(0)
        PP.getInstance(PreferenceKeys.Long).set(0L)
        PP.getInstance(PreferenceKeys.String).set("")

        Log.w("", "Boolean =    ${PP.getInstance(PreferenceKeys.Boolean).getBoolean()}")
        Log.w("", "Float =      ${PP.getInstance(PreferenceKeys.Float).getFloat()}")
        Log.w("", "Int =        ${PP.getInstance(PreferenceKeys.Int).getInt()}")
        Log.w("", "Long =       ${PP.getInstance(PreferenceKeys.Long).getLong()}")
        Log.w("", "String =     ${PP.getInstance(PreferenceKeys.String).getString()}")
        Log.w("", "String(get) =${PP.getInstance(PreferenceKeys.String).get()}")
    }


}
