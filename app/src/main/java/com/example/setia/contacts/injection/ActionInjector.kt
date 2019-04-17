package com.example.setia.contacts.injection

import com.example.setia.contacts.contactdetail.ContactDetailAction
import com.example.setia.contacts.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class)])
interface ActionInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param contactDetailAction ContactDetailAction in which to inject the dependencies
     */
    fun inject(contactDetailAction: ContactDetailAction)

    @Component.Builder
    interface Builder {
        fun build(): ActionInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}