package com.training.contactsapp.list.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.training.contactsapp.core.asLiveData
import com.training.contactsapp.core.usecase.GetAllContactsUseCase
import com.training.contactsapp.domain.Contact
import com.training.contactsapp.list.repository.ContactsRepositoryProvider
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ContactListViewModel @Inject constructor(
    useCase: GetAllContactsUseCase
) : ViewModel() {

    //FIXME resut wrapper Maybe/Optional result
    val contacts: LiveData<List<Contact>> = useCase.execute(Unit)

    // implement the screen state
    private val _showsError = MutableLiveData<Boolean>()
    val showsErrorObservable = _showsError.asLiveData()

}