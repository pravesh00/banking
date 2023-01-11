package com.example.banking.repository

import com.example.banking.repository.model.Account
import com.example.banking.repository.model.Transaction
import com.example.banking.repository.model.User

class RepositoryInstance(
    private val bankingDatabase: BankingDatabase
) {
    fun insertAccount(account: Account) = bankingDatabase.getAccountDAO().insertAccount(account)
    suspend fun getAllAccountsByID(id:Int) = bankingDatabase.getAccountDAO().getAllAccounts(id)
    suspend fun getAccountById(id: Int) = bankingDatabase.getAccountDAO().getAccountDetails(id)

    suspend fun getTransactionById(id:Int) = bankingDatabase.getTransactionDAO().getTransactionsByID(id)
    suspend fun insertTransaction(transaction: Transaction) = bankingDatabase.getTransactionDAO().insert(transaction)
   // suspend fun insertAllTransaction(vararg transactions: Transaction) = bankingDatabase.getTransactionDAO().insertAll(transactions)

    suspend fun getUserDetailsByID(id: Int) = bankingDatabase.getUserDAO().getUserById(id)
    suspend fun insertUserDetails(user: User) = bankingDatabase.getUserDAO().insert(user)

}