package com.example.setia.contacts.network

import com.example.setia.contacts.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface ContactsApi {
    /**
     * Get the list of the contacts from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<Response>
}