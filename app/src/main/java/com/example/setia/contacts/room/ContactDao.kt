package com.example.setia.contacts.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.setia.contacts.model.Contact
import io.reactivex.Single

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun getUsers(): Single<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: Contact)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<Contact>)
}