package com.miled.presentation.dagger.module

import com.miled.presentation.ui.advertisement.details.AdsDetailsFragment
import com.miled.presentation.ui.advertisement.listing.AllAdsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    internal abstract fun bindAllAdsFragment(): AllAdsFragment

    @ContributesAndroidInjector
    internal abstract fun bindAdsDetailFragment(): AdsDetailsFragment
}