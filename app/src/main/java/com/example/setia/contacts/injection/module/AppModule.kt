package com.example.setia.contacts.injection.module

import android.app.Application
import dagger.Module
import javax.inject.Singleton
import com.example.setia.contacts.App
import dagger.Provides


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