package com.and.base.component

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PP private constructor() {
    lateinit var PREFERENCES: SharedPreferences
    var name: String? = null

    // default values
    private val DEFVALUE_STRING = ""
    private val DEFVALUE_FLOAT = -1f
    private val DEFVALUE_INT = -1
    private val DEFVALUE_LONG = -1L
    private val DEFVALUE_BOOLEAN = false

    fun changeName(name: String): PP = this.apply { this.name = name }

    fun set(v: Boolean) = PREFERENCES.edit().putBoolean(name, v).apply()
    fun set(v: Int) = PREFERENCES.edit().putInt(name, v).apply()
    fun set(v: Long) = PREFERENCES.edit().putLong(name, v).apply()
    fun set(v: Float) = PREFERENCES.edit().putFloat(name, v).apply()
    fun set(v: String) = PREFERENCES.edit().putString(name, v).apply()

    fun get(): String = getString()
    fun getBoolean(): Boolean = getBoolean(DEFVALUE_BOOLEAN)
    fun getInt(): Int = getInt(DEFVALUE_INT)
    fun getLong(): Long = getLong(DEFVALUE_LONG)
    fun getFloat(): Float = getFloat(DEFVALUE_FLOAT)
    fun getString(): String = getString(DEFVALUE_STRING)

    fun getBoolean(defValues: Boolean): Boolean = PREFERENCES.getBoolean(name, defValues)
    fun getInt(defValues: Int): Int = PREFERENCES.getInt(name, defValues)
    fun getLong(defValues: Long): Long = PREFERENCES.getLong(name, defValues)
    fun getFloat(defValues: Float): Float = PREFERENCES.getFloat(name, defValues)
    fun getString(defValues: String): String = PREFERENCES.getString(name, defValues) ?: defValues

    fun contain(): Boolean = PREFERENCES.contains(name)
    fun remove(): Boolean = PREFERENCES.edit().remove(name).commit()
    fun clear(): Boolean = PREFERENCES.edit().clear().commit()

    companion object {
        private val instance: PP = PP()

        fun getInstance(param: Enum<*>): PP = instance.changeName(param.name)

        fun getInstance(name: String): PP = instance.changeName(name)

        fun CREATE(context: Context) {
            instance.PREFERENCES = PreferenceManager.getDefaultSharedPreferences(context)
        }
    }
}