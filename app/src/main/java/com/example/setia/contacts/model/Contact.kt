package com.example.setia.contacts.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact (
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: String,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="phone")
    val phone: String,
    @ColumnInfo(name="email")
    val email: String
)