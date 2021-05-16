package com.miled.presentation.dagger.module

import com.miled.presentation.ui.advertisement.details.AdsDetailsFragment
import com.miled.presentation.ui.advertisement.details.injection.AdDetailsFragmentModule
import com.miled.presentation.ui.advertisement.details.injection.AdsFragmentModule
import com.miled.presentation.ui.advertisement.listing.AllAdsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [AdsFragmentModule::class])
    internal abstract fun bindAllAdsFragment(): AllAdsFragment

    @ContributesAndroidInjector(modules = [AdDetailsFragmentModule::class])
    internal abstract fun bindAdsDetailFragment(): AdsDetailsFragment
}