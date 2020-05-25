package com.training.contactsapp.core.di.modules


import android.app.Application
import com.training.contactsapp.ContactsApplication
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {
    @Binds
    abstract fun application(app: ContactsApplication): Application
}