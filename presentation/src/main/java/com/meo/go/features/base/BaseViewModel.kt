package com.meo.go.features.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meo.infrastructure.helpers.NetworkConnection
import kotlinx.coroutines.*
import org.koin.core.KoinComponent

abstract class BaseViewModel(
    private val networkConnection: NetworkConnection
) : ViewModel(), LifecycleObserver, KoinComponent {

    private val viewModelJob: Job = Job()
    private val viewModelScope = CoroutineScope((Dispatchers.Main + viewModelJob))

    val error: LiveData<String> get() = _error
    val success: LiveData<String> get() = _success
    val loading: LiveData<Boolean> get() = _loading

    private val _error: MutableLiveData<String> = MutableLiveData()
    private val _success: MutableLiveData<String> = MutableLiveData()
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()


    fun launchData(func: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch { ->
            if (networkConnection.hasActiveInternetConnection()) {
                try {
                    _loading.value = true
                    func()
                } catch (e: Exception) {
                    onError(e.message)
                } finally {
                    _loading.value = false
                }
            } else {
                _error.value = ""
            }
        }
    }

    fun onError(message: String?) {
        _error.value = message
    }
}