package com.training.contactsapp.list.repository

import com.training.contactsapp.domain.Contact

interface ContactsRepositoryContract {

    suspend fun getAll(): List<Contact>

    suspend fun getAllLocal(): List<Contact>

    suspend fun save(contacts: List<Contact>)
}