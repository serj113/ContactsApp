package com.example.setia.contacts.contactlist

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.setia.contacts.model.Contact

class ContactViewModel: ViewModel() {
    private val contactName = MutableLiveData<String>()

    fun bind(contact: Contact) {
        contactName.value = contact.name
    }

    fun getContactName(): MutableLiveData<String> {
        return contactName
    }
}