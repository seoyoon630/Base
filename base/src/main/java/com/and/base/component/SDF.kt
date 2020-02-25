package com.and.base.component

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

enum class SDF(pattern: String, locale: Locale = Locale.getDefault()) {
    yyyymmdd("yyyyMMdd"),
    yyyymmdd_("yyyy/MM/dd"),
    yyyymmdd__("yyyy년 MM월 dd일"),
    yyyymmdd_1("yyyy-MM-dd"),
    yyyymmdd_2("yyyy.MM.dd"),

    yyyymmddhhmm("yyyyMMddHHmm"),
    yyyymmddhhmm_1("yyyy-MM-dd HH:mm"),
    yyyymmddhhmm_2("yyyy.MM.dd HH:mm"),

    yyyymmddhhmmss("yyyyMMddHHmmss"),
    yyyymmddhhmmss_("yyyy/MM/dd HH:mm:ss"),
    yyyymmddhhmmss_1("yyyy-MM-dd HH:mm:ss"),
    yyyymmddhhmmss_2("yyyy.MM.dd HH:mm:ss"),
    ddmmyyyyhhmmss_2("dd/MM/yy HH:mm:ss");

    private val sdf: SimpleDateFormat = SimpleDateFormat(pattern, locale)

    fun format(date: Date?): String = date?.let { sdf.format(date) } ?: ""

    fun format(milliseconds: Long?): String = milliseconds?.let{format(Date(milliseconds))} ?: ""

    @Throws(ParseException::class)
    fun parseDate(date: String): Date = sdf.parse(date)

    @Throws(ParseException::class)
    fun parse(date: String): Long = sdf.parse(date).time
}

