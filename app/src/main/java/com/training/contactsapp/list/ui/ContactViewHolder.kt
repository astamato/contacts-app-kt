package com.training.contactsapp.list.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.training.contactsapp.R
import com.training.contactsapp.domain.Contact

class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var name: TextView = itemView.findViewById(R.id.name)

    fun bind(item: Contact) {
        name.text = "${item.name?.first} ${item.name?.last}"
    }
}
