package com.example.setia.contacts.base

import com.example.setia.contacts.network.ContactsApi
import com.example.setia.contacts.room.ContactDao
import javax.inject.Inject

abstract class BaseAction {

    @Inject
    lateinit var API: ContactsApi

    @Inject
    lateinit var contactDao: ContactDao
}