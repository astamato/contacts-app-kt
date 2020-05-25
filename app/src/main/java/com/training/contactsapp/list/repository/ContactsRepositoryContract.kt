package com.training.contactsapp.list.repository

import com.training.contactsapp.domain.Contact
import com.training.contactsapp.domain.ContactsResult

interface ContactsRepositoryContract {

    suspend fun getContacts(): ContactsResult

    suspend fun getAllLocal(): List<Contact>

    suspend fun save(contacts: List<Contact>)
}