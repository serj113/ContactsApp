package com.example.setia.contacts.model

data class Response (
    val status: String,
    val message: String,
    val data: List<Contact>
)