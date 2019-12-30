package com.meo.infrastructure.helpers

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorHelperImpl : InterceptorHelper {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().build()
        return chain.proceed(request)
    }

    override fun httpLoggingInterceptorCreate(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { ->
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}