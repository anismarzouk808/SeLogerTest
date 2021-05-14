package com.miled.presentation.ui.advertisement.listing

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.miled.common.android.views.LoaderInterface
import com.miled.common.exhaustive
import com.miled.presentation.R
import com.miled.presentation.databinding.FragmentAdsListBinding
import com.miled.presentation.ui.models.AdvertisementUI
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AllAdsFragment : DaggerFragment(R.layout.fragment_ads_list), LoaderInterface {

    private val allAdsAdapter by lazy { AllAdsAdapter() }

    @Inject
    lateinit var viewModelFactory: AllAdsViewModel.Factory
    private val viewModel: AllAdsViewModel by viewModels(factoryProducer = { viewModelFactory })

    private var _binding: FragmentAdsListBinding? = null
    private val binding: FragmentAdsListBinding get() = requireNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentAdsListBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeData()
        viewModel.getAllAds()
        binding.errorView.setRetryListener {
            viewModel.getAllAds()
        }
    }


    private fun initRecyclerView() {
        binding.allAdsRecyclerView.adapter = allAdsAdapter
        allAdsAdapter.itemClickListener = {
            findNavController().navigate(
                AllAdsFragmentDirections.actionAdslistfragmentToAdsdetailsfragment(it)
            )
        }
    }

    private fun observeData() {
        viewModel.adsLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                AllAdsViewModel.GetAdState.Loading -> handleLoading()
                is AllAdsViewModel.GetAdState.Success -> handleSuccess(state.ads)
                is AllAdsViewModel.GetAdState.Error -> handleError(state.message)
            }.exhaustive
        })
    }

    private fun handleSuccess(ads: List<AdvertisementUI>) {
        hideRequestLoader()
        allAdsAdapter.items = ads
    }

    private fun handleLoading() {
        showRequestLoader()
    }

    private fun handleError(message: String?) {
        hideRequestLoader()
        binding.errorView.isVisible = true
        binding.errorView.setProperties(message.orEmpty(), null, true)
    }

    override fun onDestroyView() {
        binding.allAdsRecyclerView.adapter = null
        _binding = null
        super.onDestroyView()
    }

    private fun handleState() = Unit
    override val loaderContainer: View get() = binding.root
}