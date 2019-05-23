package com.example.setia.contacts.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.setia.contacts.model.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}