package com.meo.infrastructure.helpers

interface NetworkConnection {

    fun hasActiveInternetConnection(): Boolean
}