package com.example.banking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ReferActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refer)
        var name = intent.getStringExtra("name")?.toUpperCase()
        if (name != null) {
            Log.d("namename",name)
        }
        var referNumber: Int = 0
        val map = mapOf(
        'A' to 1,
        'B' to 4,
        'C' to 11,
        'D' to 26,
        'E' to 57,
        'F' to 120,
        'G' to 247,
        'H' to 502,
        'I' to 1013,
        'J' to 2036,
        'K' to 4083,
        'L' to 8178,
        'M' to 16369,
        'N' to 32752,
        'O' to 65519,
        'P' to 131054,
        'Q' to 262125,
        'R' to 524268,
        'S' to 1048555,
        'T' to 2097130,
        'U' to 4194281,
        'V' to 8388584,
        'W' to 16777191,
        'X' to 33554406,
        'Y' to 67108837,
        'Z' to 134217700)
//
        try {
            if (name != null) {
                for (i in name) {
                    referNumber += map[i]!!
                }
            }
        }finally {
            var txtRefer:TextView = findViewById(R.id.txtRefer)
            txtRefer.text = "Refer value is "+referNumber.toString()
        }


    }
}

