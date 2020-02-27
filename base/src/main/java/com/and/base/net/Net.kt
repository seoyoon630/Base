package com.and.base.net

import com.and.base.ui.BaseApplication
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class Net(
        val BASE_URL: String,
        private val interceptors: Array<Interceptor>? = null,        // 추가 interceptor
        private val networkInterceptors: Array<Interceptor>? = null, // 추가 network interceptor
        private val isGsonConverter: Boolean = true,                 // Gson Converter 사용여부
        private val isScalarsConverter: Boolean = true,              // Scalars Converter 사용여부 ( Respone String으로 받을 경우 )
        private val connectTimeout: Long = 180,                      // ConnectTimeout Default 180
        private val writeTimeout: Long = 180,                        // WriteTimeout Default 180
        private val readTimeout: Long = 180                          // ReadTimeout Default 180
) {
    val retrofit: Retrofit

    init {
        val httpClient = getClientBuilder().apply {
            // Interceptor 추가
            interceptors?.let {
                it.forEach { interceptor ->
                    addInterceptor(interceptor)
                }
            }
            networkInterceptors?.let {
                it.forEach { interceptor ->
                    addNetworkInterceptor(interceptor)
                }

            }

            // Timeout Default 180 seconds
            connectTimeout(connectTimeout, TimeUnit.SECONDS)
            writeTimeout(writeTimeout, TimeUnit.SECONDS)
            readTimeout(readTimeout, TimeUnit.SECONDS)

        }.build()

        retrofit = Retrofit.Builder().apply {
            baseUrl(BASE_URL) // BaseUrl 설정
            if (isGsonConverter) addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            if (isScalarsConverter) addConverterFactory(ScalarsConverterFactory.create())
            client(httpClient)
        }.build()
    }

    private fun getClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient().newBuilder().apply {

            addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BaseApplication.IS_DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
        }
    }
}