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
    var nametxt = MutableLiveData<String>("")
    var email =MutableLiveData<String>("")
    var address= MutableLiveData<String> ("")
    var customerId= MutableLiveData<String>("")
    var errorLog=MutableLiveData<String>("")
    var successLog=MutableLiveData<String>("")
    var error = MutableLiveData<Boolean>(false)
    //var accountID = MutableLiveData<String>("")

    fun addAccount(){
        val accountID=(0..1000000).random();
        //repository.clearDatabase()

        if(nametxt.value?.length==0 || email.value?.length==0 || nametxt.value?.length==0 ){
          //  errorLog.postValue(errorLog.value?.plus(1) ?: 0)
            errorLog.postValue("Field is missing")
        }else if(customerId.value?.length!=0 && customerId.value!=null && customerId.value!="0"){
           try {
                repository.insertAccount(Account( accountID, customerId.value!!, 0.0f))
            }catch(e:Exception){
                errorLog.postValue(e.message)
            }finally {
                successLog.postValue(nametxt.value+email.value+address.value+"Succesful" + "your account id is " +accountID.toString() + "\n" + "Your customerId is "+ customerId.value.toString())
            }
        }else{

            try {

                repository.insertAccount(Account( accountID, accountID.toString()+"BN", 0.0f))
                repository.insertUserDetails(User(nametxt.value!!,accountID.toString()+"BN", address.value!!,email.value!!))
            }catch(e:Exception){
                error.postValue(true)
                errorLog.postValue(e.message)
                Log.d("messageErr",e.message.toString())
            }finally {
                if(error.value==false)
                {   successLog.postValue(nametxt.value+email.value+address.value+"Succesful" + "your account id is " +accountID.toString() + "\n" + "Your customerId is "+ accountID.toString()+"BN")}
                else{
                    error.postValue(true)
                }
            }
        }

    }

}