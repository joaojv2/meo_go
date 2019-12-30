package com.meo.infrastructure.helpers

import com.squareup.moshi.Moshi

interface MoshiHelper {

    fun build(): Moshi
}