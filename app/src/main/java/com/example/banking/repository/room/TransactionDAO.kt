package com.example.banking.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.banking.repository.model.Transaction

@Dao
interface TransactionDAO {
    @Query("Select * from `transaction` where accountID = :id")
    fun getTransactionsByID (id:Number) :  List<Transaction>

    @Insert
    fun insert(transaction: Transaction)

    @Insert
    fun insertAll(vararg transaction: Transaction)
}