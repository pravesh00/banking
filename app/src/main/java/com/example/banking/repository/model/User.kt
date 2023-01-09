package com.example.banking.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@ColumnInfo(name="name") var name:String,@PrimaryKey var customerID:Number,@ColumnInfo(name="phoneNumber") var phoneNumber: Number,@ColumnInfo(name="email") var email:String)
