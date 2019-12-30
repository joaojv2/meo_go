package com.meo.data.mappers.base

interface BaseMapper <in Input, out Output> {

    fun map(input: Input): Output
}