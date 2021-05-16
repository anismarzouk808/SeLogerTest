package com.miled.seoger.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.miled.seoger.network.annotation.SelogerOkhhtp
import com.miled.seoger.network.annotation.SelogerRetrofit
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
class NetworkModule {

    companion object {
        const val BASE_URL = "https://gsl-apps-technical-test.dignp.com/"
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
            Timber.d(
                message,
                "OkHttp"
            )
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    @SelogerOkhhtp
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

    @SelogerRetrofit
    @Provides
    fun provideRetrofit(@SelogerOkhhtp okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}