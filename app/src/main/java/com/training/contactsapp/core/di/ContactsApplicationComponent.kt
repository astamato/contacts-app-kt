package com.training.contactsapp.core.di

import com.training.contactsapp.ContactsApplication
import com.training.contactsapp.core.di.modules.ApplicationModule
import com.training.contactsapp.core.di.modules.ContactListModule
import com.training.contactsapp.core.di.modules.NetworkModule
import com.training.contactsapp.core.di.modules.StoreModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        ContactListModule::class,
        StoreModule::class]
)
interface ContactsApplicationComponent : AndroidInjector<ContactsApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ContactsApplication): Builder
        fun build(): ContactsApplicationComponent
    }

    override fun inject(app: ContactsApplication)

}
