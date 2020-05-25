package com.training.contactsapp.list.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.training.contactsapp.R
import com.training.contactsapp.list.vm.BaseActivity
import com.training.contactsapp.list.vm.ContactListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ContactListActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: ContactListViewModel

    private val adapter: ContactListAdapter = ContactListAdapter()

    override fun provideLayoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.contacts.observe(this,
            Observer { list ->
                list?.let {
                    adapter.clear()
                    adapter.addItems(it)
                }
            })

    }

    private fun initView() {
        with(recycler) {
            adapter = this@ContactListActivity.adapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }


}
