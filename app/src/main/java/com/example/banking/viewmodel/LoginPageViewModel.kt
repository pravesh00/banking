package com.example.banking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.banking.repository.RepositoryInstance
import com.example.banking.repository.model.Account
import com.example.banking.repository.model.User
import java.lang.reflect.Executable

class LoginPageViewModel(
    private val repository: RepositoryInstance
): ViewModel() {
    val customerId = MutableLiveData<String>("")
    val message = MutableLiveData<String>("")
    val btnClicked = MutableLiveData<Boolean>(false)
    val user = MutableLiveData<User>()

    fun login(){
      //  repository.clearDatabase()
        try{
            if(customerId.value?.length!! >0)
            {   val accounts =repository.getUserDetailsByID(customerId.value!!)

                if(accounts.size>0){
                    message.postValue("Customer name is" +accounts[0].name.toString())
                    user.postValue(accounts[0])
                }else{
                    message.postValue("No accounts with this customer Id")
                }
            }
        }catch (e:Exception) {
            message.postValue("Something Went Wrong")
        }finally {
            btnClicked.postValue(true)
        }
    }

}