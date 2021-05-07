package com.miled.presentation.ui.advertisement.listing

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.miled.core.misc.Failure
import com.miled.core.misc.Loading
import com.miled.core.misc.Success
import com.miled.presentation.R
import com.miled.presentation.ui.coreview.BaseFragment

class AllAdsFragment : BaseFragment<AllAdsViewModel>(
    AllAdsViewModel::class, R.layout.fragment_ads_list
) {

    private val allAdsAdapter by lazy { AllAdsAdapter() }
    private lateinit var adsRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindToNavigationCommands(viewModel)
        initView()
        initRecyclerView()
        observeData()
        viewModel.getAllAds()
    }

    private fun initView() {
        view?.run {
            adsRecyclerView = findViewById(R.id.all_ads_recyclerView)
        }
    }


    private fun initRecyclerView() {
        adsRecyclerView.adapter = allAdsAdapter
        allAdsAdapter.itemClickListener = {
            viewModel.navigateToStoriesInfo(it)
        }
    }

    private fun observeData() {
        viewModel.adsLiveData.observe(viewLifecycleOwner, Observer { dataWrapper ->
            when (dataWrapper) {
                is Success -> {
                    allAdsAdapter.items = dataWrapper.data
                    toggleError(false, null)
                }
                is Failure -> {
                    toggleError(true, dataWrapper.throwable?.message)
                }

                is Loading -> {
                    toggleLoading(dataWrapper.loading)
                    toggleError(false, null)
                }
            }
        })
    }
}