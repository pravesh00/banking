package com.example.banking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.banking.repository.RepositoryInstance


class OpenViewModelFactory(
    private val repository: RepositoryInstance
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(OpenAccountViewModel::class.java)){
            return OpenAccountViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}