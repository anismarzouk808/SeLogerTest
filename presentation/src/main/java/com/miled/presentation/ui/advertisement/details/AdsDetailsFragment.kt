package com.miled.presentation.ui.advertisement.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.miled.commun.exhaustive
import com.miled.commun.toPriceFormat
import com.miled.core.extentions.loadUrl
import com.miled.presentation.R
import com.miled.presentation.databinding.FragmentAdsInfoBinding
import com.miled.presentation.ui.models.AdvertisementUI
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AdsDetailsFragment : DaggerFragment(R.layout.fragment_ads_info) {

    private val arguments: AdsDetailsFragmentArgs by navArgs()

    private var _binding: FragmentAdsInfoBinding? = null
    private val binding: FragmentAdsInfoBinding get() = requireNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: AdsDetailViewModel.Factory
    private val viewModel: AdsDetailViewModel by viewModels(factoryProducer = { viewModelFactory })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentAdsInfoBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        observeData()
        initListener()
        viewModel.getAdsDetails(arguments.advertisementId)
    }

    private fun fillView(advertisementui: AdvertisementUI) {
        binding.draweeAdsPicture.loadUrl(advertisementui.url)
        binding.textAdsType.text = advertisementui.propertyType
        binding.textAdsPrice.text = advertisementui.price.toPriceFormat()

        if (advertisementui.rooms != 0) {
            binding.textRoomNumber.visibility = View.VISIBLE
            binding.textRoomNumber.text =
                getString(R.string.text_ads_rooms, advertisementui.rooms)
        }

        if (advertisementui.bedrooms != 0) {
            binding.textBedroomNumber.visibility = View.VISIBLE
            binding.textBedroomNumber.text =
                getString(R.string.text_ads_bedrooms, advertisementui.bedrooms)
        }

        if (advertisementui.area != 0.0) {
            binding.textArea.visibility = View.VISIBLE
            binding.textArea.text =
                getString(R.string.text_ads_area, advertisementui.area)
        }

        binding.textAdsCity.text = advertisementui.city
        binding.textAdsProfessional.text = advertisementui.professional
    }

    private fun initListener() {
        binding.imageViewBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun observeData() {
        viewModel.adsDetailLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is AdsDetailViewModel.AdDetailState.Success -> handleSuccess(state.details)
                is AdsDetailViewModel.AdDetailState.Error -> handleError(state.message)
                AdsDetailViewModel.AdDetailState.Loading -> handleLoading()
            }.exhaustive
        })
    }

    private fun handleSuccess(advertismentUi: AdvertisementUI) {
        //hide Loading
        fillView(advertismentUi)
    }

    private fun handleLoading() {
        //show Loading
    }

    private fun handleError(message: String?) {
        //hide Loading
        //show message Error
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}