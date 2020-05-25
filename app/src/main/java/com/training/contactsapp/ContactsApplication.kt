package com.training.contactsapp

import android.app.Application
import com.facebook.stetho.Stetho
import com.training.contactsapp.ContactsApplication_MembersInjector.create
import com.training.contactsapp.core.di.DaggerContactsApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class ContactsApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerContactsApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)

        Timber.plant(Timber.DebugTree())
        Stetho.initializeWithDefaults(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}
