package com.training.contactsapp.core.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.training.contactsapp.domain.Contact
import com.training.contactsapp.list.repository.ContactsRepositoryContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class GetAllContactsUseCase @Inject constructor(
    private val repositoryProvider: ContactsRepositoryContract
) : UseCase<Unit, LiveData<List<Contact>>> {

    override fun execute(value: Unit) = liveData {
        try {
            //blows up unannounced when no connection
            val dataFromNetwork = resolveContactsRemote()
            emit(dataFromNetwork)
        } catch (ioException: Exception) {
            emit(repositoryProvider.getAllLocal())
            Timber.e(ioException)
        }
    }

    private suspend fun resolveContactsRemote() = withContext(Dispatchers.IO) {
        val results = repositoryProvider.getAll()
        repositoryProvider.save(results)
        results
    }

}