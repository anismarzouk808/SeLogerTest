package com.miled.data.injection

import com.miled.data.remote.AdsApiService
import com.miled.data.remote.AdsRepositoryImp
import com.miled.domain.repository.AdsRepository
import com.miled.seoger.network.annotation.SelogerRetrofit
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class SeLogerApiModule {
    @Binds
    abstract fun provideAccount2faRepository(repository: AdsRepositoryImp): AdsRepository

    companion object {
        @Provides
        fun provideAdsApiService(@SelogerRetrofit retrofit: Retrofit): AdsApiService {
            return retrofit.create(AdsApiService::class.java)
        }
    }
}