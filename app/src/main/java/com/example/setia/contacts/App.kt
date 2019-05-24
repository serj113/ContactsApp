package com.example.setia.contacts

import android.app.Application
import android.util.Log
import com.example.setia.contacts.injection.AppInjector
import com.example.setia.contacts.injection.DaggerAppInjector
import com.example.setia.contacts.injection.module.AppModule
import com.example.setia.contacts.injection.module.DaoModule
import com.example.setia.contacts.injection.module.NetworkModule

class App: Application() {

    private lateinit var appInjector: AppInjector

    override fun onCreate() {
        super.onCreate()
        appInjector = initDagger(this)
    }

    private fun initDagger(app: App): AppInjector =
        DaggerAppInjector.builder()
            .appModule(AppModule(app))
            .daoModule(DaoModule(app))
            .networkModule(NetworkModule)
            .build()

    fun getInjector(): AppInjector {
        return appInjector
    }
}