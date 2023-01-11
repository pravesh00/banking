package com.example.banking.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@ColumnInfo(name="name") var name:String,@PrimaryKey var customerID:String,@ColumnInfo(name="address") var address: String,@ColumnInfo(name="email") var email:String)
