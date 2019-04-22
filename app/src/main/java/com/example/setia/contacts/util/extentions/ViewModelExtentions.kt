package com.example.setia.contacts.util.extentions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

fun <T : ViewModel> createFor(model: T): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(model.javaClass)) {
                @Suppress("UNCHECKED_CAST")
                return model as T
            }
            throw IllegalArgumentException("unexpected model class $modelClass")
        }
    }
}