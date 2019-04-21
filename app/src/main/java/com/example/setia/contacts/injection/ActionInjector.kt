package com.example.setia.contacts.injection

import com.example.setia.contacts.base.implementation.ActionVM
import com.example.setia.contacts.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ActionInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param action ActionVM in which to inject the dependencies
     */
    fun inject(action: ActionVM)

    @Component.Builder
    interface Builder {
        fun build(): ActionInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}