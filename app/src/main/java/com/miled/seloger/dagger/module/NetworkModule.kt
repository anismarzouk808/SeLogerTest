package com.miled.seloger.dagger.module

import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

@Module
class NetworkModule {
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
}