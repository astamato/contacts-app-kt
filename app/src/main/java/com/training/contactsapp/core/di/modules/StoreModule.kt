package com.training.contactsapp.core.di.modules


import androidx.room.Room
import com.training.contactsapp.ContactsApplication
import com.training.contactsapp.list.repository.disk.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class StoreModule {

    @Provides
    fun provideAppDatabase(app: ContactsApplication): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

    companion object {
        const val DATABASE_NAME = "contacts-db"
    }

}
