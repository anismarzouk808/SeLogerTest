package com.miled.presentation.ui.advertisement.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.miled.core.extentions.setLoadingState
import com.miled.core.misc.DataWrapper
import com.miled.core.misc.ErrorType
import com.miled.core.misc.Failure
import com.miled.core.misc.Success
import com.miled.domain.usecase.GetAdsDetailsUseCase
import com.miled.presentation.ui.coreview.BaseViewModel
import com.miled.presentation.ui.models.AdvertisementUI
import com.miled.presentation.ui.models.toUi
import javax.inject.Inject


class AdsDetailViewModel @Inject constructor(
    private val getAdsDetailsUseCase: GetAdsDetailsUseCase,
) :
    BaseViewModel() {

    private val _adsDetailLiveData = MutableLiveData<DataWrapper<AdvertisementUI>>()

    val adsDetailLiveData: LiveData<DataWrapper<AdvertisementUI>> get() = _adsDetailLiveData

    fun getAdsDetails(id: Int) {
        _adsDetailLiveData.setLoadingState(true)
        getAdsDetailsUseCase(id).sub({
            _adsDetailLiveData.setLoadingState(false)
            _adsDetailLiveData.postValue(Success(it.toUi()))
        }, { throwable ->
            _adsDetailLiveData.setLoadingState(false)
            _adsDetailLiveData.postValue(
                Failure(
                    AdsDetailErrorType.GET_ADS_DETAIL_ERROR,
                    throwable
                )
            )
        })
    }
}

enum class AdsDetailErrorType : ErrorType {
    GET_ADS_DETAIL_ERROR
}