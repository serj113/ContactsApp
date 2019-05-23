package com.example.setia.contacts.injection

import com.example.setia.contacts.App
import com.example.setia.contacts.base.BaseAction
import com.example.setia.contacts.injection.module.AppModule
import com.example.setia.contacts.injection.module.DaoModule
import com.example.setia.contacts.injection.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
// @Component(modules = [(AppModule::class), (NetworkModule::class), (DaoModule::class)])
@Component(modules = [(AppModule::class), (NetworkModule::class), (DaoModule::class)])
interface AppInjector {

    // @Component.Builder
    // abstract class Builder : AndroidInjector<App>()

    fun inject(action: BaseAction)

    @Component.Builder
    interface Builder {
        // fun appModule(appModule: AppModule): Builder

        fun appModule(appModule: AppModule): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun daoModule(daoModule: DaoModule): Builder

        fun build(): AppInjector
    }
}