package com.example.banking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banking.adapters.TransactionAdapter
import com.example.banking.databinding.ActivityActionsBinding
import com.example.banking.repository.BankingDatabase
import com.example.banking.repository.RepositoryInstance
import com.example.banking.repository.model.Account
import com.example.banking.repository.model.Transaction
import com.example.banking.viewmodel.TransactionViewModel
import com.example.banking.viewmodel.TransactionViewModelFactory

class ActionsActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    private lateinit var bankingDatabase: BankingDatabase
    private lateinit var repo: RepositoryInstance
    private lateinit var binding: ActivityActionsBinding
    private lateinit var viewModel: TransactionViewModel
    private lateinit var adapter: TransactionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_actions)
        bankingDatabase= BankingDatabase(this)
        var accountID=0
        accountID = intent.getStringExtra("accountID")?.toInt()!!

        repo= RepositoryInstance(BankingDatabase(applicationContext))
        val factory = TransactionViewModelFactory(repo, accountID)
        viewModel= ViewModelProvider(this,factory).get(TransactionViewModel::class.java)
        binding.transaction=viewModel
        //var accountID = intent.getStringExtra("accountID")?.toFloat()?.plus(0.0f)
        //Toast.makeText(this,accountID.toString(),Toast.LENGTH_LONG).show()
        viewModel.message.observe(this,Observer{
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.getTransactions()
        var transactions = ArrayList<Transaction>()
        adapter= TransactionAdapter(transactions)
        binding.recyclerTransactions.adapter = adapter
        binding.recyclerTransactions.layoutManager = LinearLayoutManager(this)
        viewModel.transactions.observe(this, Observer {
            if(it!=null && it.size>0) {
                transactions.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

    }
}