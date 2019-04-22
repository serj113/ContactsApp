package com.example.setia.contacts.contactlist

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.setia.contacts.base.BaseVM
import com.example.setia.contacts.model.Contact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ContactListViewModel: BaseVM<ContactListAction>() {

    private val action = ContactListAction()
    private val disposes = CompositeDisposable()

    private val contactList: MutableLiveData<List<Contact>> = MutableLiveData()

    fun getContactList(): LiveData<List<Contact>> = contactList

    fun loadData() {
        val disposable: Disposable = action.getContactObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    contactList.value = it.Data
                    Log.d("tada", "${getContactList().value?.size ?: 0}")
                },
                {
                    contactList.value = listOf()
                    Log.d("tada", it.localizedMessage)
                }
            )

        disposes.add(disposable)
    }

    override fun onCleared() {
        disposes.clear()
        super.onCleared()
    }

}