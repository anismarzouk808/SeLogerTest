package com.miled.seloger.dagger.component

import android.app.Application
import com.miled.presentation.dagger.module.ActivityBindingModule
import com.miled.presentation.dagger.module.FragmentBindingModule
import com.miled.presentation.dagger.module.ViewModelModule
import com.miled.seloger.dagger.module.ApplicationModule
import com.miled.seloger.dagger.module.NetworkModule
import com.miled.seloger.dagger.module.SeLogerApiModule
import com.miled.seloger.dagger.module.UseCaseModule
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
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        SeLogerApiModule::class,
        UseCaseModule::class
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