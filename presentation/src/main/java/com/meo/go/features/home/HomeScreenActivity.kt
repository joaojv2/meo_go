package com.meo.go.features.home

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.meo.domain.aggregate.ChannelCatalog
import com.meo.go.R
import com.meo.go.databinding.ActivityHomeScreenBinding
import com.meo.go.extensions.bind
import com.meo.go.features.base.BaseActivity
import com.meo.go.utilities.InfiniteScroll
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeScreenActivity : BaseActivity() {

    lateinit var adapter: HomeScreenAdapter
    lateinit var binding: ActivityHomeScreenBinding

    override val viewModel: HomeScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)

        subscribeUi()
        recyclerViewFactory()
    }

    private fun subscribeUi() {
        bind(viewModel.loading, ::onLoading)
        bind(viewModel.channelCatalog, ::onChannelCatalog)
    }

    private fun recyclerViewFactory() {
        adapter = HomeScreenAdapter()
        binding.recyclerViewChannels.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.recyclerViewChannels.layoutManager = linearLayoutManager
        binding.recyclerViewChannels.addOnScrollListener(
            InfiniteScroll(linearLayoutManager) {
                viewModel.getChannels(
                    viewModel.channelCatalog.value?.nextLink?.replace("http", "https")
                )
            }
        )
    }

    private fun onLoading(loading: Boolean) {
        if (loading) {
            binding.constraintProgressBar.visibility = View.VISIBLE
        } else {
            binding.constraintProgressBar.visibility = View.GONE
        }
    }

    private fun onChannelCatalog(channelCatalog: ChannelCatalog) {
        channelCatalog.channels?.let { adapter.submitList(it) }
    }
}
