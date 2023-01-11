package com.example.banking.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Transaction(@PrimaryKey var transactionID:Int,@ColumnInfo(name="accountID") var accountID:Int,@ColumnInfo(name="type") var type:String,@ColumnInfo(name="isCredit") var isCredit:Boolean,@ColumnInfo(name="date") var date:String)
