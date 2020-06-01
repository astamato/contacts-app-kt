package com.training.contactsapp.core.di.modules


import androidx.room.Room
import com.training.contactsapp.ContactsApplication
import com.training.contactsapp.list.repository.disk.AppDatabase
import com.training.contactsapp.list.repository.disk.ContactsDiskDataSource
import com.training.contactsapp.list.repository.disk.ContactsRoomDataSource
import com.training.contactsapp.list.repository.network.ContactsNetworkDataSource
import com.training.contactsapp.list.repository.network.ContactsRetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [StoreModule.Declarations::class])
class StoreModule {

    @Provides
    fun provideAppDatabase(app: ContactsApplication): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

    @Module
    internal interface Declarations {

        @Binds
        fun provide(dataSource: ContactsRoomDataSource): ContactsDiskDataSource

    }

    companion object {
        const val DATABASE_NAME = "contacts-db"
    }

}
