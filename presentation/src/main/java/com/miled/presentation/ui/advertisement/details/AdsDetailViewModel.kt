package com.miled.presentation.ui.advertisement.details

import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.miled.common.disposeBy
import com.miled.common.android.misc.ErrorType
import com.miled.domain.usecase.GetAdsDetailsUseCase
import com.miled.presentation.ui.models.AdvertisementUI
import com.miled.presentation.ui.models.toUi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AdsDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getAdsDetailsUseCase: GetAdsDetailsUseCase,
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val _adsDetailLiveData = MutableLiveData<AdDetailState>()

    val adsDetailLiveData: LiveData<AdDetailState> get() = _adsDetailLiveData

    fun getAdsDetails(id: Int) {
        _adsDetailLiveData.value = AdDetailState.Loading
        getAdsDetailsUseCase(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                _adsDetailLiveData.value = AdDetailState.Success(it.toUi())
            }, {
                _adsDetailLiveData.value = AdDetailState.Error(it.message)
            }).disposeBy(disposables)
    }

    sealed class AdDetailState {
        object Loading : AdDetailState()
        data class Success(val details: AdvertisementUI) : AdDetailState()
        data class Error(val message: String?) : AdDetailState()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    class Factory @Inject constructor(
        owner: SavedStateRegistryOwner,
        private val getAdsDetailsUseCase: GetAdsDetailsUseCase
    ) : AbstractSavedStateViewModelFactory(owner, null) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return AdsDetailViewModel(
                handle, getAdsDetailsUseCase
            ) as T
        }
    }

}

enum class AdsDetailErrorType : ErrorType {
    GET_ADS_DETAIL_ERROR
}