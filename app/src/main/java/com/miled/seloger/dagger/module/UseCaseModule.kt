package com.miled.seloger.dagger.module

import com.miled.domain.repository.AdsRepository
import com.miled.domain.usecase.GetAllAdsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideAllAdsUseCase(adsRepository: AdsRepository)
            : GetAllAdsUseCase = GetAllAdsUseCase(adsRepository)
}