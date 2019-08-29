package com.example.setia.contacts.model

data class Response (
    val status: Int,
    val message: String,
    val data: List<Contact>
)