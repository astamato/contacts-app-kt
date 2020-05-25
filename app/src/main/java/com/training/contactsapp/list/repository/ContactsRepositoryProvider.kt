package com.training.contactsapp.list.repository

import com.training.contactsapp.domain.Contact
import com.training.contactsapp.list.repository.disk.ContactsDao
import com.training.contactsapp.list.repository.network.ContactsNetworkDataSource
import javax.inject.Inject

class ContactsRepositoryProvider @Inject constructor(
    private val dao: ContactsDao,
    private val networkDataSource: ContactsNetworkDataSource
) : ContactsRepositoryContract {

    override suspend fun getContacts() = networkDataSource.getContacts()

    override suspend fun save(contacts: List<Contact>) {
        dao.insertAllContacts(contacts)
    }

    override suspend fun getAllLocal() = dao.getAll()

}