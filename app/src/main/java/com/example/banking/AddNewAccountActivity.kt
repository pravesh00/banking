package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_account)

        //binding.txtAddress.setText("hell")
        bankingDatabase= BankingDatabase(this)
        repo= RepositoryInstance(BankingDatabase(applicationContext))
        val factory = OpenViewModelFactory(repo)
        viewModel=ViewModelProvider(this,factory).get(OpenAccountViewModel::class.java)
        binding.account=viewModel

        viewModel.errorLog.observe(this,Observer{
            if(it.length>0){
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })

        viewModel.successLog.observe(this,Observer{
            if(it.length>0){
                try {
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }finally {
                    var intent = Intent(this,CongratsActivityActivity::class.java)
                    var bundle = Bundle()
                    bundle.putString("message",it)
                    intent.putExtras(bundle)
                    startActivity(intent)

                }
            }
        })

    }
}