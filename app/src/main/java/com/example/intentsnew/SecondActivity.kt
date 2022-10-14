package com.example.intentsnew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.intentsnew.model.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button: Button = findViewById(R.id.btnBack)
        val textView: TextView = findViewById(R.id.textView2)

        val user = intent.getSerializableExtra("user") as User
        textView.text = "${user.id}\n${user.name}\n${user.lastName}\n${user.age}"

        button.setOnClickListener {
            // onBackPressed()
            finish()
        }
    }
}