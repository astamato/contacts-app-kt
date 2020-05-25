package com.training.contactsapp.list.repository.network

import com.training.contactsapp.domain.ContactsResult

interface ContactsNetworkDataSource {

    suspend fun getContacts(): ContactsResult
}