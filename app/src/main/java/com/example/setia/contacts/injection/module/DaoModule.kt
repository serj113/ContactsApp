package com.example.setia.contacts.injection.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.setia.contacts.App
import com.example.setia.contacts.room.AppDatabase
import com.example.setia.contacts.room.ContactDao
import com.example.setia.contacts.util.AppContext
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Inject
import javax.inject.Singleton

@Module
@Suppress("unused")
class DaoModule(app: App) {

    private var room: AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "contact-db").build()

    /**
     * Provides the Contact Dao implementation.
     * @param  appDatabase AppDatabase object used to get contactDao using its method
     * @return ContactDao instance.
     */
    @Provides
    @Reusable
    fun provideContactDao(): ContactDao {
        return room.contactDao()
    }

    /**
     * Provides the Contact Dao implementation.
     * @param context the Context object used to instantiate the AppDatabse
     * @return AppDatabase instance.
     */
    @Provides
    @Reusable
    fun provideAppDatabase(): AppDatabase {
        return room
    }
}