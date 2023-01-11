package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banking.adapters.AccountAdapter
import com.example.banking.repository.BankingDatabase
import com.example.banking.repository.RepositoryInstance
import com.example.banking.repository.model.Account

class AccountsActivity : AppCompatActivity() {
    private lateinit var bankingDatabase: BankingDatabase
    private lateinit var repo: RepositoryInstance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)
        var customer = intent.getStringExtra("customerid")
        var name= intent.getStringExtra("name")
        if (customer != null) {
            Log.d("customer",customer)
        }
        var recyclerView: RecyclerView = findViewById(R.id.recyclerAccounts)
        var button: Button = findViewById(R.id.btnRefer)
        var accounts = ArrayList<Account>()
        bankingDatabase= BankingDatabase(this)
        repo= RepositoryInstance(BankingDatabase(applicationContext))

        accounts.add(Account(1222,customer.toString(),122f))
        var adapter = AccountAdapter(accounts)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        try{
            accounts.clear()
            accounts.addAll(repo.getAllAccountsByID(customer.toString()))

        }finally {
            //adapter.updateAccount(accounts)
            adapter.notifyDataSetChanged()
        }
        button.setOnClickListener{
            var intent = Intent(this,ReferActivity::class.java)
            var bundle = Bundle()
            bundle.putString("name",name);
            intent.putExtras(bundle)
            startActivity(intent)
        }



    }
}