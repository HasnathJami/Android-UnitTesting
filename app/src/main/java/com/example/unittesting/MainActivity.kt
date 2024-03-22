package com.example.unittesting

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleButtonClickAction()
    }

    private fun sendDataToAnotherActivity(view: View) {
        val value = findViewById<EditText>(R.id.et_name).text.toString()
        startActivity(Intent(this@MainActivity, SecondActivity::class.java).putExtra("name",value))
    }

    private fun handleButtonClickAction() {
        findViewById<Button>(R.id.btn_send).setOnClickListener(::sendDataToAnotherActivity)
    }
}