package com.training.contactsapp.list.repository.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import com.training.contactsapp.domain.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}