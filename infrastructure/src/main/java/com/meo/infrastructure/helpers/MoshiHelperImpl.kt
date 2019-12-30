package com.meo.infrastructure.helpers

import com.meo.infrastructure.helpers.MoshiHelper
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiHelperImpl : MoshiHelper {

    override fun build(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}