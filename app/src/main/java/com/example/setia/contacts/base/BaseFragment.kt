package com.example.setia.contacts.base

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment<V>: Fragment() {

    var vm: V? = null

    abstract fun initVM()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVM()
    }

}