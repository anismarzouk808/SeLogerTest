package com.miled.presentation.ui.advertisement.details.injection

import androidx.savedstate.SavedStateRegistryOwner
import com.miled.presentation.ui.advertisement.listing.AllAdsFragment
import dagger.Binds
import dagger.Module


@Module
abstract class AdsFragmentModule {
    //@FragmentScope
    @Binds
    abstract fun provideSavedStateRegistryOwner(fragment: AllAdsFragment): SavedStateRegistryOwner
}