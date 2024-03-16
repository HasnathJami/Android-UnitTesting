package com.example.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        performActionWithReceivedValue()
    }

    private fun performActionWithReceivedValue() {
        if(intent.extras != null && intent.extras!!.containsKey("name")) {
            findViewById<TextView>(R.id.tv_name).text = intent!!.extras?.getString("name").toString()
        }
    }
}