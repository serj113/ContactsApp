package com.example.setia.contacts

import android.app.Application
import com.example.setia.contacts.contactlist.ContactListViewModel
import com.example.setia.contacts.model.Contact
import com.example.setia.contacts.model.Response
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ContactListViewModelUT {

    lateinit var contactListViewModel: ContactListViewModel

    @Mock
    lateinit var mockApplication: Application

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        contactListViewModel = ContactListViewModel(mockApplication)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun loadData() {
        val response = Response(
            200,
            "Success",
            listOf(
                Contact(
                    "1",
                    "Tada",
                    "085208520852",
                    "tada@gmail.com"
                )
            )
        )
        Mockito.`when`(contactListViewModel.actions?.getContactObservable())
            .thenReturn(Observable.just(response))

        val result = contactListViewModel.getContactList().value?.first()

        Assert.assertEquals(result?.id, "1")
    }
}