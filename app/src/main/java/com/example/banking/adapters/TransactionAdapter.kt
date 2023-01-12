package com.example.banking.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banking.databinding.AccountLayoutItemBinding
import com.example.banking.databinding.TransactionLayoutItemBinding
import com.example.banking.repository.model.Transaction

class TransactionAdapter(var transactions: ArrayList<Transaction>): RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: TransactionLayoutItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TransactionLayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction= transactions[position]
        if(transaction.isCredit){
            holder.binding.txtAmount.setTextColor(Color.parseColor("Green"))
        }else{
            holder.binding.txtAmount.setTextColor(Color.parseColor("Red"))
        }
        holder.binding.txtAmount.setText("Transaction Amount: "+transaction.amt.toString())
        holder.binding.txtDate.setText("Date "+transaction.date.toString())
        holder.binding.txtTransactionID.setText("Transaction ID : "+transaction.transactionID.toString())
    }

    override fun getItemCount(): Int {
       return transactions.size
    }


}