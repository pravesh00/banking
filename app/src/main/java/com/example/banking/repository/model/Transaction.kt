package com.example.banking.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Transaction(@PrimaryKey var transactionID:Number,@ColumnInfo(name="accountID") var accountID:Number,@ColumnInfo(name="type") var type:String,@ColumnInfo(name="isCredit") var isCredit:Boolean,@ColumnInfo(name="date") var date:Date)
