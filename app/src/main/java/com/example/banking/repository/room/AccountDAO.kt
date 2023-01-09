package com.example.banking.repository.room

import android.accounts.Account
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDAO {
    @Insert
    fun insertAccount(account: Account)

    @Query("SELECT * from account where customerID = :id")
    fun getAllAccounts(id:Number) : List<Account>

    @Query("Select * from account where accountID= :id")
    fun getAccountDetails(id:Number) : List<Account>

}