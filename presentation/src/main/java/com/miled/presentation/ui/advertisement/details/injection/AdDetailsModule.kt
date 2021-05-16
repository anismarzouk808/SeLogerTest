package com.miled.presentation.ui.advertisement.details.injection

import androidx.savedstate.SavedStateRegistryOwner
import com.miled.presentation.dagger.scopes.FragmentScope
import com.miled.presentation.ui.advertisement.details.AdsDetailsFragment
import dagger.Binds
import dagger.Module


@Module
abstract class AdDetailsFragmentModule {
    //@FragmentScope
    @Binds
    abstract fun provideSavedStateRegistryOwner(fragment: AdsDetailsFragment): SavedStateRegistryOwner
}