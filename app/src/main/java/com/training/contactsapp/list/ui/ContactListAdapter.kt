package com.training.contactsapp.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.contactsapp.R
import com.training.contactsapp.core.ui.BaseRecyclerViewAdapter
import com.training.contactsapp.domain.Contact

class ContactListAdapter : BaseRecyclerViewAdapter<Contact>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.contact_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val customerViewHolder = holder as? ContactViewHolder

        getItem(position)?.let {
            customerViewHolder?.bind(item = it)
        }
    }

}