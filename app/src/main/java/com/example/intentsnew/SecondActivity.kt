package com.example.intentsnew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.intentsnew.model.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button: Button = findViewById(R.id.btnBack)
        val textView: TextView = findViewById(R.id.textView2)

        val user = intent.getParcelableExtra<User>("user")!!
        textView.text = "${user.name}\n${user.lastName}\n${user.age}"

        button.setOnClickListener {
            val intent = Intent()
            val bundle = bundleOf("user1" to User("Kotlin", "Android", 23))
            intent.putExtras(bundle)
            setResult(100, intent)
            finish()
        }
    }
}