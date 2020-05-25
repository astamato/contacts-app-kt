package com.training.contactsapp.list.repository.network

import javax.inject.Inject

class ContactsRetrofitDataSource @Inject constructor(
    var contactApi: ContactApi
) : ContactsNetworkDataSource {

    override suspend fun getContacts() = contactApi.getContacts()

}