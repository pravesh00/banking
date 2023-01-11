package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.banking.R
import com.google.android.material.button.MaterialButton

class LoginCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_customer)
        var btnLogin: Button = findViewById(R.id.btnLogin)
        var txtCustomerID : TextView = findViewById(R.id.txtCustomerID)


    }
}