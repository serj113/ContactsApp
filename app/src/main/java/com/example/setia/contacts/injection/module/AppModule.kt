package com.example.setia.contacts.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import javax.inject.Singleton
import dagger.Binds
import com.example.setia.contacts.App
import com.example.setia.contacts.util.AppContext
import dagger.Provides
import dagger.Reusable
import dagger.android.support.AndroidSupportInjectionModule


// @Module(includes = [AndroidSupportInjectionModule::class])
// @Suppress("unused")
// abstract class AppModule {
//     @Binds
//     @Singleton
//     abstract fun provideContext(app: App): Context
// }

@Module
@Suppress("unused")
class AppModule(private var app: App) {

    @Provides
    @Singleton
    internal fun providesContext(): Application {
        return app
    }
}