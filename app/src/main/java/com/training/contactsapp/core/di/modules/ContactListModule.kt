package com.training.contactsapp.core.di.modules

import androidx.lifecycle.ViewModel
import com.training.contactsapp.core.di.ViewModelKey
import com.training.contactsapp.list.repository.ContactsRepositoryContract
import com.training.contactsapp.list.repository.ContactsRepositoryProvider
import com.training.contactsapp.list.repository.disk.AppDatabase
import com.training.contactsapp.list.repository.disk.ContactsDao
import com.training.contactsapp.list.repository.network.ContactsNetworkDataSource
import com.training.contactsapp.list.ui.ContactListActivity
import com.training.contactsapp.list.vm.ContactListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module(includes = [ContactListModule.Declarations::class])
class ContactListModule {

    @Singleton
    @Provides
    fun providesProductDao(appDatabase: AppDatabase): ContactsDao {
        return appDatabase.contactsDao()
    }

    @Module
    internal interface Declarations {

        @ContributesAndroidInjector
        fun provideActivity(): ContactListActivity

        @Binds
        @IntoMap
        @ViewModelKey(ContactListViewModel::class)
        fun provideViewModel(viewModel: ContactListViewModel): ViewModel

        @Binds
        fun provideRepository(provider: ContactsRepositoryProvider): ContactsRepositoryContract
    }
}

