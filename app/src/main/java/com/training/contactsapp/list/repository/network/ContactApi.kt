package com.training.contactsapp.list.repository.network

import com.training.contactsapp.domain.ContactsResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ContactApi {

    @GET("api")
    suspend fun getContacts(
        @Query("seed") seed: String = SERVICE_SEED,
        @Query("results") results: String = SERVICE_RESULT_AMOUNT
    ): ContactsResult

    @GET("api")
    suspend fun getContact(
        @Query("seed") seed: String = SERVICE_SEED
    ): ContactsResult

    companion object {
        const val SERVICE_SEED = "ale"
        const val SERVICE_RESULT_AMOUNT = "15"
    }
}