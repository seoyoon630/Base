package com.and.base.net


inline fun <reified T> createNetService(net: Net): T {
    return net.retrofit.create(T::class.java)
}
