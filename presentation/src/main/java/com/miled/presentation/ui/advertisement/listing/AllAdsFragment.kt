package com.miled.presentation.ui.advertisement.listing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.miled.commun.exhaustive
import com.miled.presentation.R
import com.miled.presentation.databinding.FragmentAdsListBinding
import com.miled.presentation.ui.models.AdvertisementUI
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AllAdsFragment : DaggerFragment(R.layout.fragment_ads_list) {

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
                is AllAdsViewModel.GetAdState.Success -> handleSuccess(state.ads)
                is AllAdsViewModel.GetAdState.Error -> handleState()
                is AllAdsViewModel.GetAdState.Loading -> handleState()
            }.exhaustive
        })
    }

    private fun handleSuccess(ads: List<AdvertisementUI>) {
        allAdsAdapter.items = ads
    }

    override fun onDestroyView() {
        binding.allAdsRecyclerView.adapter = null
        _binding = null
        super.onDestroyView()
    }

    private fun handleState() = Unit
}