package com.example.intentsnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var isFinish = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        button.setOnLongClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", "Android Development")
            intent.putExtra("name1", "IOS Development")
            intent.putExtra("int", 10)
            intent.putExtra("float", 4f)
            intent.putExtra("image", R.drawable.img)
            startActivity(intent)
            true
        }
    }

    override fun onBackPressed() {
//        if (isFinish) {
//            super.onBackPressed()
//            return
//        }
//
//        isFinish = true
//        Toast.makeText(this, "Press again", Toast.LENGTH_SHORT).show()
//        Handler(mainLooper).postDelayed({
//            isFinish = false
//        }, 1000)

        AlertDialog.Builder(this).apply {
            setTitle("Exit")
            setMessage("Do you want to exit?")
            setPositiveButton("Yes") { di, _ ->
                di.dismiss()
                super.onBackPressed()
            }
            setNegativeButton("No", null)
        }.create().show()
    }
}