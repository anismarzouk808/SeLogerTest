package com.miled.presentation.ui.advertisement.listing

import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.miled.common.disposeBy
import com.miled.domain.models.Ad
import com.miled.domain.usecase.GetAllAdsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AllAdsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getAllAdsUseCase: GetAllAdsUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val _adsLiveData = MutableLiveData<GetAdState>()

    val adsLiveData: LiveData<GetAdState> get() = _adsLiveData

    fun getAllAds() {
        _adsLiveData.value = GetAdState.Loading
        getAllAdsUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { response ->
                    _adsLiveData.value = GetAdState.Success(response.items)
                }, { throwable ->
                    _adsLiveData.value = GetAdState.Error(throwable.message)
                }
            )
            .disposeBy(disposables)
    }

    sealed class GetAdState {
        object Loading : GetAdState()
        data class Success(val ads: List<Ad>) : GetAdState()
        data class Error(val message: String?) : GetAdState()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    class Factory @Inject constructor(
        owner: SavedStateRegistryOwner,
        private val getAllAdsUseCase: GetAllAdsUseCase
    ) : AbstractSavedStateViewModelFactory(owner, null) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return AllAdsViewModel(
                handle, getAllAdsUseCase
            ) as T
        }
    }
}