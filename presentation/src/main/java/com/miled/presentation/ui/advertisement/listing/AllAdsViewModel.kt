package com.miled.presentation.ui.advertisement.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.miled.core.extentions.setLoadingState
import com.miled.core.misc.DataWrapper
import com.miled.core.misc.ErrorType
import com.miled.core.misc.Failure
import com.miled.core.misc.Success
import com.miled.domain.usecase.GetAllAdsUseCase
import com.miled.presentation.ui.coreview.BaseViewModel
import com.miled.presentation.ui.models.AdvertisementUI
import com.miled.presentation.ui.models.toUi
import javax.inject.Inject

class AllAdsViewModel @Inject constructor(
    private val getAllAdsUseCase: GetAllAdsUseCase,
) :
    BaseViewModel() {

    private val _adsLiveData = MutableLiveData<DataWrapper<List<AdvertisementUI>>>()

    val adsLiveData: LiveData<DataWrapper<List<AdvertisementUI>>> get() = _adsLiveData

    fun getAllAds() {
        _adsLiveData.setLoadingState(true)
        getAllAdsUseCase().sub({
            _adsLiveData.setLoadingState(false)
            _adsLiveData.postValue(Success(it.items.map { it.toUi() }))
        }, { throwable ->
            _adsLiveData.setLoadingState(false)
            _adsLiveData.postValue(Failure(AllAdsErrorType.GET_All_ADS_ERROR, throwable))
        })
    }

    fun navigateToStoriesInfo(advertisementId: Int) {
        navigate(
            AllAdsFragmentDirections.actionAdslistfragmentToAdsdetailsfragment(
                advertisementId
            )
        )
    }
}

enum class AllAdsErrorType : ErrorType {
    GET_All_ADS_ERROR
}