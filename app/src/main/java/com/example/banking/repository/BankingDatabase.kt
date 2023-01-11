package com.example.banking.repository

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.banking.repository.model.Account
import com.example.banking.repository.model.Transaction
import com.example.banking.repository.model.User
import com.example.banking.repository.room.AccountDAO
import com.example.banking.repository.room.TransactionDAO
import com.example.banking.repository.room.UserDAO


@Database(
    entities = [Account::class,Transaction::class, User::class],
    version = 1,
    exportSchema = true
)

abstract class BankingDatabase: RoomDatabase() {
    abstract fun getAccountDAO(): AccountDAO
    abstract fun getTransactionDAO(): TransactionDAO
    abstract fun getUserDAO(): UserDAO

    companion object {
        private const val DB_NAME = "banking_database.db"
        @Volatile private var instance: BankingDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BankingDatabase::class.java,
            DB_NAME
        ).allowMainThreadQueries().build()
    }
}
