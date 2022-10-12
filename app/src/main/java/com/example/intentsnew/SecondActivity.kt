package com.example.intentsnew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button: Button = findViewById(R.id.btnBack)
        val textView: TextView = findViewById(R.id.textView2)
        val imageView: ImageView = findViewById(R.id.imageView)
        val text = intent.getStringExtra("name")
        val text2 = intent.getStringExtra("name1")
        val float = intent.getFloatExtra("float", 0f)
        val image = intent.getIntExtra("image", -1)
        textView.text = "$text\n$text2\n$float"

        imageView.setImageResource(image)

        button.setOnClickListener {
            // onBackPressed()
            finish()
        }
    }
}