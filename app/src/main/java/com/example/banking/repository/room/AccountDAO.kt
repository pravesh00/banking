package com.example.banking.repository.room


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.banking.repository.model.Account

@Dao
interface AccountDAO {
    @Insert
    fun insertAccount(account: Account)

    @Query("SELECT * from account where customerID = :id")
    fun getAllAccounts(id:String) : List<Account>

    @Query("Select * from account where accountID= :id")
    fun getAccountDetails(id:Int) : List<Account>

}