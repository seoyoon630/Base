package com.and.base.component

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Date.format(sdf : SDF) : String = SimpleDateFormat(sdf.pattern, sdf.locale).format(this)

fun Long.format(sdf : SDF) : String = SimpleDateFormat(sdf.pattern, sdf.locale).format(this)

@Throws(ParseException::class)
fun String.parseDate(sdf : SDF) : Date? = SimpleDateFormat(sdf.pattern, sdf.locale).parse(this)

@Throws(ParseException::class)
fun String.parseLong(sdf : SDF) : Long? = SimpleDateFormat(sdf.pattern, sdf.locale).parse(this)?.time

enum class SDF(val pattern: String, val locale: Locale = Locale.getDefault()) {
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
}

