package com.example.banking.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(@PrimaryKey var accountID:Number,@ColumnInfo(name="customerID") var customerID:String,@ColumnInfo(name="balance") var balance:Float)
