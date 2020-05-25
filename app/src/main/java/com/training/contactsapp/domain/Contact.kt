package com.training.contactsapp.domain

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity
data class Contact(
//    @PrimaryKey(autoGenerate = true)
//    @Exclude
//    val id: Long = 0,
    @PrimaryKey
    @SerializedName("name")
    @Embedded
    val name: Name = Name()
)

data class Name(
    @SerializedName("title")
    val title: String = "",
    @ColumnInfo(name = "first")
    @SerializedName("first")
    val first: String = "",
    @ColumnInfo(name = "last")
    @SerializedName("last")
    val last: String = ""
)
//
//data class Location(
//    @SerializedName("street")
//    val street: Street? = null,
//    @SerializedName("city")
//    val city: String = "",
//    @SerializedName("country")
//    val country: String = ""
//)

//data class Street(
//    @SerializedName("number")
//    val number: Int = 0,
//    @SerializedName("name")
//    val name: String = ""
//)

//data class Login(
//    @PrimaryKey
//    @SerializedName("uuid")
//    val uuid: String = ""
//)