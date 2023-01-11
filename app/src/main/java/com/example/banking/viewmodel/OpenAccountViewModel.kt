package com.example.banking.viewmodel

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.banking.repository.RepositoryInstance
import com.example.banking.repository.model.Account
import com.example.banking.repository.model.User

class OpenAccountViewModel(
    private val repository: RepositoryInstance
): ViewModel() {
    lateinit var newAccount: MutableLiveData<Account>
    lateinit var newUser: MutableLiveData<User>

    fun addAccount(){
        if(newAccount!=null){
            newAccount.value?.let { repository.insertAccount(it) }
            Log.d("res","clicked")
        }
    }

}