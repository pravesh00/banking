package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    lateinit var btnLogin:MaterialButton;
    lateinit var btnLoginByAdmin:MaterialButton;
    lateinit var btnOpenAccount:MaterialButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
        btnLogin.setOnClickListener{
            var intent= Intent(this, LoginCustomerActivity::class.java);
            startActivity(intent)
            finish()
        }
        btnLoginByAdmin.setOnClickListener {
            var intent= Intent(this,AccountsActivity::class.java);
            startActivity(intent)
            finish()
        }
        btnOpenAccount.setOnClickListener {
            var intent= Intent(this,AddNewAccountActivity::class.java);
            startActivity(intent)
            finish()
        }
    }

    fun init(){
        btnLogin=findViewById(R.id.btnLoginCustomer)
        btnLoginByAdmin=findViewById(R.id.btnLoginAdmin)
        btnOpenAccount=findViewById(R.id.btnAddNewAccount)
    }
}