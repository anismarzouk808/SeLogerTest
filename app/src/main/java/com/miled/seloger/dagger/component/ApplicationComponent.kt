package com.miled.seloger.dagger.component

import android.app.Application
import com.miled.data.injection.SeLogerApiModule
import com.miled.presentation.dagger.module.FragmentBindingModule
import com.miled.seloger.dagger.module.ApplicationModule
import com.miled.seoger.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        FragmentBindingModule::class,
        NetworkModule::class,
        SeLogerApiModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}