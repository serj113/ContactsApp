package com.example.setia.contacts.contactlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.setia.contacts.base.BaseVM
import com.example.setia.contacts.model.Contact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ContactListViewModel: BaseVM<ContactListAction>() {

    private val action = ContactListAction()

    private val contactList: MutableLiveData<List<Contact>> = MutableLiveData()

    fun getContactList(): LiveData<List<Contact>> = contactList

    fun loadData() {
        action.getContactObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    contactList.value = it.data
                },
                {
                    contactList.value = listOf()
                }
            )
    }

}