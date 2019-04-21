package com.example.setia.contacts.model

data class Response (
    val Status: Int,
    val Message: String,
    val Data: List<Contact>
)