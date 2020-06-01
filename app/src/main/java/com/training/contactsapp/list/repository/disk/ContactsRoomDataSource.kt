package com.training.contactsapp.list.repository.disk

import com.training.contactsapp.domain.Contact
import javax.inject.Inject

class ContactsRoomDataSource @Inject constructor(
    private val dao: ContactsDao
) : ContactsDiskDataSource {

    override suspend fun getAll() = dao.getAll()

    override suspend fun save(contacts: List<Contact>) = dao.insertAllContacts(contacts)

}