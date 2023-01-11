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
    val newAccount= MutableLiveData<Account>(Account(2,"c",0.0f))
    val newUser= MutableLiveData<User>()


    var nametxt = MutableLiveData<String>("")
    var email =MutableLiveData<String>("")
    var address= MutableLiveData<String> ("")
    var customerId= MutableLiveData<String>("")
    var errorLog=MutableLiveData<String>("")
    var successLog=MutableLiveData<String>("")

    fun addAccount(){
        if(nametxt.value?.length==0 || email.value?.length==0 || nametxt.value?.length==0 ){
          //  errorLog.postValue(errorLog.value?.plus(1) ?: 0)
            errorLog.postValue("Field is missing")
        }else if(customerId.value?.length!=0 && customerId.value!=null && customerId.value!="0"){
            val accountID=(0..1000000).random();
            try {
                repository.insertAccount(Account( accountID, customerId.value!!, 0.0f))
            }catch(e:Exception){
                errorLog.postValue(e.message)
            }finally {
                successLog.postValue("Succesful" + "your account id is" +accountID.toString())
            }
        }else{
            val accountID=(0..1000000).random();

            try {
                repository.insertAccount(Account( accountID, accountID.toString()+"BN", 0.0f))
            }catch(e:Exception){
                errorLog.postValue(e.message)
            }finally {
                successLog.postValue("Succesful"+"your account id is" +accountID.toString())
            }
        }

    }

}