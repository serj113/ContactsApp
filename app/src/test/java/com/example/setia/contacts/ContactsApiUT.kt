package com.example.setia.contacts

import com.example.setia.contacts.model.Contact
import com.example.setia.contacts.model.Response
import com.example.setia.contacts.network.ContactsApi
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when`



class ContactsApiUT {

    @Mock
    lateinit var contactsApi: ContactsApi

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun getContact() {
        val reponse = Response(
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
        `when`(contactsApi.getPosts())
            .thenReturn(Observable.just(reponse))

        val testObserver = TestObserver<Response>()
        contactsApi.getPosts().subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)

        val result = testObserver.values().first()

        assertEquals(result.Status, 200)
    }

}