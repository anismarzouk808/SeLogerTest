package com.miled.presentation.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miled.presentation.dagger.annotation.ViewModelKey
import com.miled.presentation.dagger.factory.AppViewModelFactory
import com.miled.presentation.ui.advertisement.details.AdsDetailViewModel
import com.miled.presentation.ui.advertisement.listing.AllAdsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AllAdsViewModel::class)
    internal abstract fun provideAllAdsViewModel(allAdsViewModel: AllAdsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AdsDetailViewModel::class)
    internal abstract fun provideAdsDetailViewModel(adsDetailViewModel: AdsDetailViewModel): ViewModel
}