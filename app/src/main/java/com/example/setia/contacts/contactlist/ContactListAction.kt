package com.example.setia.contacts.contactlist

import com.example.setia.contacts.base.implementation.ActionVM
import com.example.setia.contacts.model.Response
import io.reactivex.Observable

class ContactListAction: ActionVM() {

    fun getContactObservable(): Observable<Response> {
        return API.getPosts()
    }

}