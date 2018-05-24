package net.alhazmy13.demoproject.di

import dagger.Component
import net.alhazmy13.demoproject.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}