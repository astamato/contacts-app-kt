package com.training.contactsapp.list.repository.disk

import com.training.contactsapp.domain.Contact

interface ContactsDiskDataSource {

    suspend fun getAll(): List<Contact>

    suspend fun save(contacts: List<Contact>)

}