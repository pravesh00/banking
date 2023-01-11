package com.example.banking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CongratsActivityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats_activity)
        var txtMssg: TextView = findViewById(R.id.txtMessageSuccess)
        var message = intent.getStringExtra("message")
       // var accountID = intent.getBundleExtra("AccountID")
        txtMssg.setText(message)

    }
}