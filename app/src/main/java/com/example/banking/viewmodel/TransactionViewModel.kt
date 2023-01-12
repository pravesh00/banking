package com.example.banking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.banking.repository.RepositoryInstance
import com.example.banking.repository.model.Transaction

class TransactionViewModel(
    private val repository: RepositoryInstance,
    private val account: Int
): ViewModel() {
    val amount = MutableLiveData<String>()
    val message = MutableLiveData<String>("")
    val transactions = MutableLiveData<List<Transaction>>()
    fun withdraw(){
        val trId=(0..100000000).random();
        if(amount.value==null || amount.value.toString().toInt()==0 ){
            message.postValue("Enter a valid amount")
            return
        }
        try {
            repository.insertTransaction(
                Transaction(
                    trId,
                    account,
                    "Withdraw",
                    false,
                    "2000-01-01",
                    amount.value.toString().toFloat()
                )
            );
            repository.addAmountAccount(amount.value.toString().toFloat()*-1,account)
        }finally {
            message.postValue(trId.toString()+" "+account.toString()+" "+amount.value.toString())
        }
    }

    fun deposit(){
        val trId=(0..100000000).random();
        if(amount.value==null || amount.value.toString().toInt()==0 ){
            message.postValue("Enter a valid amount")
            return
        }
        try {
            repository.insertTransaction(
                Transaction(
                    trId,
                    account,
                    "Deposit",
                    true,
                    "2000-01-01",
                    amount.value.toString().toFloat()
                )
            );
            repository.addAmountAccount(amount.value.toString().toFloat(),account)
        }finally {
            message.postValue(trId.toString()+" "+account.toString()+" "+amount.value.toString())
        }
    }
    fun getTransactions(){
        try{
            var tr:List<Transaction> =repository.getTransactionById(account)
            transactions.postValue(tr)
        }catch(e:Exception){

        }finally {

        }
    }
}