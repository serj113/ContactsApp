package com.example.setia.contacts.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

abstract class BaseVM<A: BaseAction>(app: Application): AndroidViewModel(app) {

    var actions: A? = null

    abstract fun initActions()

    init {
        initActions()
    }

}