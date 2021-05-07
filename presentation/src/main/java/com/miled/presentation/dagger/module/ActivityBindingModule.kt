package com.miled.presentation.dagger.module

import com.miled.presentation.ui.advertisement.AdsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): AdsActivity
}