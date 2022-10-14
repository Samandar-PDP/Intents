package com.example.intentsnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import com.example.intentsnew.model.User

class MainActivity : AppCompatActivity() {
    private var isFinish = false
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName: EditText = findViewById(R.id.editTextTextPersonName)
        val editLastName: EditText = findViewById(R.id.editTextTextPersonName2)
        val editAge: EditText = findViewById(R.id.editTextTextPersonName3)
        val button: Button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        button.setOnClickListener {
            val name = editName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()
            val age = editAge.text.toString().trim()
            val user = User(name, lastName, age.toInt())
            val bundle = bundleOf("user" to user)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtras(bundle)
            registerActivity.launch(intent)
        }
    }

    private val registerActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == 100) {
                val user = it?.data?.getParcelableExtra<User>("user1")!!
                textView.text = "${user.name}\n${user.lastName}\n${user.age}"
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