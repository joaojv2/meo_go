package com.meo.go.features.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.response.RemoteResponse
import com.meo.domain.usecases.ChannelsUseCase
import com.meo.domain.usecases.ProgramsUseCase
import com.meo.go.features.base.BaseViewModel
import com.meo.go.utilities.Constants
import com.meo.infrastructure.helpers.NetworkConnection


class HomeScreenViewModel(
    networkConnection: NetworkConnection,
    private val channelsUseCase: ChannelsUseCase,
    private val programsUseCase: ProgramsUseCase
) : BaseViewModel(networkConnection) {

    val channelCatalog: LiveData<ChannelCatalog> get() = _channelCatalog

    private val _channelCatalog: MutableLiveData<ChannelCatalog> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getChannels()
    }

    fun getChannels(url: String? = null) {
        launchData { ->
            when (val response = channelsUseCase.getChannelCatalog(url)) {
                is RemoteResponse.Error -> onError(response.message)
                is RemoteResponse.Success -> {
                    response.body.channels?.forEach { channels ->
                        when (
                            val programs = programsUseCase.getProgramCatalog(
                                channels.callLetter ?: ""))
                        {
                            is RemoteResponse.Success -> channels.programs = programs.body
                            is RemoteResponse.Error -> onError(programs.message)
                        }

                        channels.imageUrl =
                            Constants.IMAGE_URL.format(channels.title, channels.callLetter)
                    }

                    _channelCatalog.value = response.body
                }
            }
        }
    }
}