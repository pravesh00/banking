package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.banking.R
import com.example.banking.databinding.ActivityLoginCustomerBinding
import com.example.banking.repository.BankingDatabase
import com.example.banking.repository.RepositoryInstance
import com.example.banking.viewmodel.LoginPageViewModel
import com.example.banking.viewmodel.LoginViewModelFactory
import com.example.banking.viewmodel.OpenAccountViewModel
import com.example.banking.viewmodel.OpenViewModelFactory
import com.google.android.material.button.MaterialButton

class LoginCustomerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginCustomerBinding
    private lateinit var viewModel: LoginPageViewModel
    private lateinit var bankingDatabase: BankingDatabase
    private lateinit var repo: RepositoryInstance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login_customer)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login_customer)
        bankingDatabase= BankingDatabase(this)
        repo= RepositoryInstance(BankingDatabase(applicationContext))
        val factory = LoginViewModelFactory(repo)
        viewModel=ViewModelProvider(this,factory).get(LoginPageViewModel::class.java)
        binding.login=viewModel
        viewModel.message.observe(this, Observer {
            if(it.length>0)
            {Toast.makeText(this,it,Toast.LENGTH_LONG).show()}
        });
        viewModel.btnClicked.observe(this) {
            if (it) {
                var intent = Intent(this, AccountsActivity::class.java)
                var bundle = Bundle()
                bundle.putString("customerid", viewModel.customerId.value)
                bundle.putString("name",viewModel.user.value?.name.toString())
                intent.putExtras(bundle)
                startActivity(intent)
                finish()
            }
        }


    }
}