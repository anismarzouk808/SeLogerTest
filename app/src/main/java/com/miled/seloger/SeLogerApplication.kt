package com.miled.seloger

import com.facebook.drawee.backends.pipeline.Fresco
import com.miled.seloger.dagger.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SeLogerApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

    /**
     * Initialize application and domain dependency injection component.
     */
    override fun applicationInjector(): AndroidInjector<DaggerApplication> {
        val appComponent = DaggerApplicationComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}