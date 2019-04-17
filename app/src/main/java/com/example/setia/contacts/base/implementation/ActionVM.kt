package com.example.setia.contacts.base.implementation

import com.example.setia.contacts.base.BaseAction
import com.example.setia.contacts.network.ContactsApi
import javax.inject.Inject

class ActionVM: BaseAction() {

    @Inject
    lateinit var API: ContactsApi

}