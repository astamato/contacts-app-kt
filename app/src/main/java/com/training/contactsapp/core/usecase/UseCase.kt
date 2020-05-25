package com.training.contactsapp.core.usecase

interface UseCase<INPUT, OUTPUT> {

    fun execute(value: INPUT): OUTPUT

}