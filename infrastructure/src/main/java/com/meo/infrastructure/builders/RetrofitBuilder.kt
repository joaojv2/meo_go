package com.meo.infrastructure.builders

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.meo.infrastructure.R
import com.meo.infrastructure.helpers.InterceptorHelper
import com.meo.infrastructure.helpers.MoshiHelper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder(
    val moshiHelper: MoshiHelper,
    val interceptorHelper: InterceptorHelper
) {

    inline fun <reified T> build(context: Context): T {
        return OkHttpClient.Builder()
            .addInterceptor(interceptorHelper)
            .addInterceptor(interceptorHelper.httpLoggingInterceptorCreate())
            .build()
            .let { build(context, it) }
    }

    inline fun <reified T> build(context: Context, client: OkHttpClient): T {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshiHelper.build()))
            .build()
            .create(T::class.java)
    }
}