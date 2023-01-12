package com.example.banking.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(@PrimaryKey var accountID:Int,@ColumnInfo(name="customerID") var customerID:String="C12",@ColumnInfo(name="balance") var balance:Float=0.0f,@ColumnInfo(name="type") var type:String)
