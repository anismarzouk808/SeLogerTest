package com.miled.presentation.ui.advertisement.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.miled.common.android.extentions.loadUrl
import com.miled.common.android.views.LoaderInterface
import com.miled.common.exhaustive
import com.miled.common.toPriceFormat
import com.miled.domain.models.Ad
import com.miled.presentation.R
import com.miled.presentation.databinding.FragmentAdsInfoBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AdsDetailsFragment : DaggerFragment(R.layout.fragment_ads_info), LoaderInterface {

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

    private fun fillView(ad: Ad) {
        binding.draweeAdsPicture.loadUrl(ad.url)
        binding.textAdsType.text = ad.propertyType
        binding.textAdsPrice.text = ad.price.toPriceFormat()

        if (ad.rooms != 0) {
            binding.textRoomNumber.visibility = View.VISIBLE
            binding.textRoomNumber.text =
                getString(R.string.text_ads_rooms, ad.rooms)
        }

        if (ad.bedrooms != 0) {
            binding.textBedroomNumber.visibility = View.VISIBLE
            binding.textBedroomNumber.text =
                getString(R.string.text_ads_bedrooms, ad.bedrooms)
        }

        if (ad.area != 0.0) {
            binding.textArea.visibility = View.VISIBLE
            binding.textArea.text =
                getString(R.string.text_ads_area, ad.area)
        }

        binding.textAdsCity.text = ad.city
        binding.textAdsProfessional.text = ad.professional
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

    private fun handleSuccess(ad: Ad) {
        hideRequestLoader()
        fillView(ad)
    }

    private fun handleLoading() {
        showRequestLoader()
    }

    private fun handleError(message: String?) {
        hideRequestLoader()
        binding.errorView.setProperties(title = message.orEmpty(), retryBtnVisible = true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override val loaderContainer: View get() = binding.root
}