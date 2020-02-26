package com.and.base.component

class EE {
    val name: String
    val msg: Any?

    constructor(name: String, msg: Any? = null) {
        this.name = name
        this.msg = msg
    }

    constructor(enum: Enum<*>, msg: Any? = null) {
        this.name = enum.name
        this.msg = msg
    }
}