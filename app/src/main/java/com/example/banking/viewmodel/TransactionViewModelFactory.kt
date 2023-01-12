package com.example.banking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.banking.repository.RepositoryInstance

class TransactionViewModelFactory(private val repository: RepositoryInstance,private val account: Int
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TransactionViewModel::class.java)){
            return TransactionViewModel(repository,account) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}