package com.example.banking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.banking.repository.RepositoryInstance
import com.example.banking.repository.model.Account
import java.lang.reflect.Executable

class LoginPageViewModel(
    private val repository: RepositoryInstance
): ViewModel() {
    val customerId = MutableLiveData<String>("")
    val message = MutableLiveData<String>("")
    val btnClicked = MutableLiveData<Boolean>(false)

    fun login(){
        try{
            if(customerId.value?.length!! >0)
            {   val accounts =repository.getAllAccountsByID(customerId.value!!)
                if(accounts.size>0){
                    btnClicked.postValue(true)

                }else{
                    message.postValue("No accounts with this customer Id")
                }
            }
        }catch (e:Exception) {
            message.postValue("Something Went Wrong")
        }
    }

}