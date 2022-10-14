package com.example.intentsnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import com.example.intentsnew.model.User

class MainActivity : AppCompatActivity() {
    private var isFinish = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        button.setOnLongClickListener {
            val user = User(id = 1, name = "Kotlinjon", lastName = "Androidov", age = 10)
            val intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            intent.putExtras(bundle)
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
//           val bundle1 = bundleOf("name" to "Android Development", )
//            val bundle2 = bundleOf("int" to 10)
//            val bundleAll = Bundle()
//            bundleAll.putAll(bundle2)
//            bundleAll.putAll(bundle1)
//            intent.putExtras(bundleAll)