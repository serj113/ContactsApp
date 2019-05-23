package com.example.setia.contacts.contactlist

import com.example.setia.contacts.base.BaseAction
import com.example.setia.contacts.model.Response
import io.reactivex.Observable

class ContactListAction: BaseAction() {

    fun getContactObservable(): Observable<Response> {
        return API.getPosts()
    }

}