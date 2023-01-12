package com.example.banking.repository

import com.example.banking.repository.model.Account
import com.example.banking.repository.model.Transaction
import com.example.banking.repository.model.User

class RepositoryInstance(
    private val bankingDatabase: BankingDatabase
) {
    fun insertAccount(account: Account) = bankingDatabase.getAccountDAO().insertAccount(account)
    fun getAllAccountsByID(id:String) = bankingDatabase.getAccountDAO().getAllAccounts(id)
    fun getAccountById(id: Int) = bankingDatabase.getAccountDAO().getAccountDetails(id)

    fun getTransactionById(id:Int) = bankingDatabase.getTransactionDAO().getTransactionsByID(id)
    fun insertTransaction(transaction: Transaction) = bankingDatabase.getTransactionDAO().insert(transaction)
   // suspend fun insertAllTransaction(vararg transactions: Transaction) = bankingDatabase.getTransactionDAO().insertAll(transactions)

    fun getUserDetailsByID(id: String) = bankingDatabase.getUserDAO().getUserById(id)
    fun insertUserDetails(user: User) = bankingDatabase.getUserDAO().insert(user)
    fun addAmountAccount(amt:Float, id:Int) = bankingDatabase.getAccountDAO().addAmountToAccount(amt,id)
    fun clearDatabase()  = bankingDatabase.clearAllTables()

}