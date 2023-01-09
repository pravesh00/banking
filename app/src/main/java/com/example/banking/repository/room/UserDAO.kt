package com.example.banking.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.banking.repository.model.User

@Dao
interface UserDAO {
    @Query("Select * From user where customerID = :id")
    fun getUserById(id:Number) : List<User>

    @Insert
    fun insert(user: User)

    @Insert
    fun insertALL(vararg users:User)

}