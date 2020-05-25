package com.training.contactsapp.list.repository.disk

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.training.contactsapp.domain.Contact

@Dao
interface ContactsDao {

    @Query("SELECT * FROM contact")
    suspend fun getAll(): List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllContacts(order: List<Contact>)

}