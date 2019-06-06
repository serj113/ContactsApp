package com.example.setia.contacts.contactlist

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.setia.contacts.App
import com.example.setia.contacts.base.BaseAction
import com.example.setia.contacts.base.BaseVM
import com.example.setia.contacts.model.Contact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ContactListViewModel(app: Application): BaseVM<ContactListAction>(app) {

    private val disposes = CompositeDisposable()

    private val contactList: MutableLiveData<List<Contact>> = MutableLiveData()

    override fun initActions() {
        actions = ContactListAction()
        if (actions is BaseAction) {
            (getApplication<Application>() as? App)?.getInjector()?.inject(actions!!)
        }
    }

    fun getContactList(): LiveData<List<Contact>> = contactList

    fun loadData() {
        val disposable: Disposable? = actions?.getContactObservable()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    contactList.value = it.Data
                },
                {
                    contactList.value = listOf()
                    Log.d("tada", it.localizedMessage)
                }
            )

        if (disposable != null) disposes.add(disposable)
    }

    override fun onCleared() {
        disposes.clear()
        super.onCleared()
    }

}