package com.meo.go.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.bind(data: LiveData<T>, func: (t: T) -> Unit) {
    data.observe(this,  Observer(func))
}