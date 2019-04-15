package com.example.setia.contacts.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.example.setia.contacts.contactdetail.ContactDetailViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}