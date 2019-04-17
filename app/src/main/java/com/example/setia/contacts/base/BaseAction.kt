package com.example.setia.contacts.base

import com.example.setia.contacts.contactdetail.ContactDetailAction
import com.example.setia.contacts.injection.ActionInjector
import com.example.setia.contacts.injection.DaggerActionInjector
import com.example.setia.contacts.injection.module.NetworkModule

abstract class BaseAction {

    private val injector: ActionInjector = DaggerActionInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is ContactDetailAction -> injector.inject(this)
        }
    }
}