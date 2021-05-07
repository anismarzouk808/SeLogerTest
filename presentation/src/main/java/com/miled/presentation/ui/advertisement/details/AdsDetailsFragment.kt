package com.miled.presentation.ui.advertisement.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.facebook.drawee.view.SimpleDraweeView
import com.miled.commun.utils.toPriceFormat
import com.miled.core.extentions.loadUrl
import com.miled.core.misc.Failure
import com.miled.core.misc.Loading
import com.miled.core.misc.Success
import com.miled.presentation.R
import com.miled.presentation.ui.coreview.BaseFragment
import com.miled.presentation.ui.models.AdvertisementUI

class AdsDetailsFragment : BaseFragment<AdsDetailViewModel>(
    AdsDetailViewModel::class, R.layout.fragment_ads_info
) {

    private lateinit var draweeAdsPicture: SimpleDraweeView
    private lateinit var imageViewBack: AppCompatImageView
    private lateinit var textAdsType: AppCompatTextView
    private lateinit var textAdsPrice: AppCompatTextView
    private lateinit var textRoomNumber: AppCompatTextView
    private lateinit var textBedroomNumber: AppCompatTextView
    private lateinit var textArea: AppCompatTextView
    private lateinit var textAdsCity: AppCompatTextView
    private lateinit var textAdsProfessional: AppCompatTextView
    private val arguments: AdsDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
        initListener()
        viewModel.getAdsDetails(arguments.advertisementId)
    }

    private fun initView() {
        view?.run {
            draweeAdsPicture = findViewById(R.id.drawee_ads_picture)
            imageViewBack = findViewById(R.id.image_view_back)
            textAdsType = findViewById(R.id.text_ads_type)
            textAdsPrice = findViewById(R.id.text_ads_price)
            textRoomNumber = findViewById(R.id.text_room_number)
            textBedroomNumber = findViewById(R.id.text_bedroom_number)
            textArea = findViewById(R.id.text_area)
            textAdsCity = findViewById(R.id.text_ads_city)
            textAdsProfessional = findViewById(R.id.text_ads_professional)
        }
    }

    private fun fillView(advertisementui: AdvertisementUI) {
        draweeAdsPicture.loadUrl(advertisementui.url)
        textAdsType.text = advertisementui.propertyType
        textAdsPrice.text = advertisementui.price.toPriceFormat()

        if (advertisementui.rooms != 0) {
            textRoomNumber.visibility = View.VISIBLE
            textRoomNumber.text =
                resources.getString(R.string.text_ads_rooms, advertisementui.rooms)
        }

        if (advertisementui.bedrooms != 0) {
            textBedroomNumber.visibility = View.VISIBLE
            textBedroomNumber.text =
                resources.getString(R.string.text_ads_bedrooms, advertisementui.bedrooms)
        }

        if (advertisementui.area != 0.0) {
            textArea.visibility = View.VISIBLE
            textArea.text = resources.getString(R.string.text_ads_area, advertisementui.area)
        }

        textAdsCity.text = advertisementui.city
        textAdsProfessional.text = advertisementui.professional
    }

    private fun initListener() {
        imageViewBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun observeData() {
        viewModel.adsDetailLiveData.observe(viewLifecycleOwner, Observer { dataWrapper ->
            when (dataWrapper) {
                is Success -> {
                    fillView(dataWrapper.data)
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