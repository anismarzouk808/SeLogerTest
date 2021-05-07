package com.miled.seloger.dagger.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.miled.data.remote.AdsApiService
import com.miled.data.remote.AdsRepositoryImp
import com.miled.domain.BuildConfig
import com.miled.domain.repository.AdsRepository
import com.miled.seloger.dagger.annotation.AllAdsCallApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class SeLogerApiModule {

    @Provides
    @Singleton
    fun provideAdsRepository(apiService: AdsApiService): AdsRepository {
        return AdsRepositoryImp(apiService)
    }

    @Provides
    fun provideAdsApiService(@AllAdsCallApi okHttpClient: OkHttpClient): AdsApiService {
        return Retrofit.Builder().baseUrl(BuildConfig.API_ADS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(AdsApiService::class.java)
    }

    @AllAdsCallApi
    @Provides
    fun provideAdsApiOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(StethoInterceptor())
            .addNetworkInterceptor { chain ->
                val request = chain.request()
                val newUrl = request.url.newBuilder().build()
                val newRequest = request.newBuilder().url(newUrl).build()

                chain.proceed(newRequest)
            }.build()
    }
}