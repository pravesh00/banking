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

        viewModel.customerId.observe(this, Observer {
            if(it.length>0){
                binding.btnCheckMyId.isEnabled = true
                binding.txtName.setText("")
                binding.txtEmail.setText("")
                binding.txtAddress.setText("")
                binding.txtName.isEnabled = false
                binding.txtEmail.isEnabled = false
                binding.txtAddress.isEnabled = false
                binding.btnCreateAccount.isEnabled = false
            }else{
                binding.btnCheckMyId.isEnabled = false
                binding.txtName.isEnabled = true
                binding.txtEmail.isEnabled = true
                binding.txtAddress.isEnabled = true
                binding.btnCreateAccount.isEnabled = true
            }
        })

        viewModel.checkingID.observe(this, Observer {
            binding.txtName.setText(viewModel.nametxt.value)
            binding.txtAddress.setText(viewModel.address.value)
            binding.txtEmail.setText(viewModel.email.value)
            binding.btnCreateAccount.isEnabled=true
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