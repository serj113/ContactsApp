package com.example.setia.contacts.base

import com.example.setia.contacts.base.implementation.ActionVM
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
            is ActionVM -> injector.inject(this)
        }
    }
}