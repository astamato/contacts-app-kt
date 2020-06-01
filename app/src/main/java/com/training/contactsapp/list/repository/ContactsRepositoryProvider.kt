package com.training.contactsapp.list.repository

import com.training.contactsapp.domain.Contact
import com.training.contactsapp.list.repository.disk.ContactsDao
import com.training.contactsapp.list.repository.disk.ContactsDiskDataSource
import com.training.contactsapp.list.repository.network.ContactsNetworkDataSource
import javax.inject.Inject

class ContactsRepositoryProvider @Inject constructor(
    private val diskDataSource: ContactsDiskDataSource,
    private val networkDataSource: ContactsNetworkDataSource
) : ContactsRepositoryContract {

    override suspend fun getContacts() = networkDataSource.getContacts()

    override suspend fun save(contacts: List<Contact>) {
        diskDataSource.save(contacts)
    }

    override suspend fun getAllLocal() = diskDataSource.getAll()

}