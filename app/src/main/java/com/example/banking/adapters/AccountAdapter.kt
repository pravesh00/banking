package com.example.banking.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banking.databinding.AccountLayoutItemBinding
import com.example.banking.repository.model.Account

class AccountAdapter(var accounts: ArrayList<Account>): RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

    fun updateAccount(newaccounts:ArrayList<Account>){
        accounts.clear()
        accounts.addAll(newaccounts)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: AccountLayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AccountLayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val account = accounts[position]
        holder.binding.txtAccountBalance.setText(account.balance.toString())
        holder.binding.txtAccountNumber.setText(account.accountID.toString())
    }

    override fun getItemCount(): Int {
        return accounts.size
    }
}