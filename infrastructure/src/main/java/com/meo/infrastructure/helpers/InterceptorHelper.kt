package com.meo.infrastructure.helpers

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

interface InterceptorHelper : Interceptor {

    fun httpLoggingInterceptorCreate(): HttpLoggingInterceptor
}