package net.alhazmy13.demoproject

import android.app.Application
import net.alhazmy13.demoproject.di.ApplicationComponent
import net.alhazmy13.demoproject.di.DaggerApplicationComponent
import net.alhazmy13.demoproject.di.NetworkModule


class DemoApplication:Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        buildApplicationComponent()
    }

    private fun buildApplicationComponent(){
        applicationComponent = DaggerApplicationComponent.builder()
                .build()
    }

}