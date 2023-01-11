package com.example.banking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.banking.databinding.ActivityAddNewAccountBinding
import com.example.banking.repository.BankingDatabase
import com.example.banking.repository.RepositoryInstance
import com.example.banking.viewmodel.OpenAccountViewModel
import com.example.banking.viewmodel.OpenViewModelFactory

class AddNewAccountActivity : AppCompatActivity() {
    private lateinit var viewModel: OpenAccountViewModel
    private lateinit var bankingDatabase: BankingDatabase
    private lateinit var repo:RepositoryInstance
    private lateinit var binding:ActivityAddNewAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAddNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.txtAddress.setText("hell")
        bankingDatabase= BankingDatabase(this)
        repo= RepositoryInstance(BankingDatabase(applicationContext))
        val factory = OpenViewModelFactory(repo)
        viewModel=ViewModelProvider(this,factory).get(OpenAccountViewModel::class.java)

    }
}