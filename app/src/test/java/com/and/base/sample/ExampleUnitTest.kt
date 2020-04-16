package com.and.base.sample

import com.and.base.log.Log
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun LogTest() {
        Log.d("test")
        Log.i("test2")
        Log.e("test3")
        Log.w("test4")
        Log.json("{\"dd\":\"dd\"}")
    }
}
