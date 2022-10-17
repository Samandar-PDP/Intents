package com.example.intentsnew

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class SmsActivity : AppCompatActivity() {
    private lateinit var editMessage: EditText
    private lateinit var editPhone: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        editMessage = findViewById(R.id.editMessage)
        editPhone = findViewById(R.id.editNumber)
        val btnSend: Button = findViewById(R.id.btnSend)
        val btnWeb: Button = findViewById(R.id.btnWeb)

        val btnSms: Button = findViewById(R.id.btnSms)
        val btnCall: Button = findViewById(R.id.btnCall)

        btnWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://youtube.com")
            startActivity(intent)
        }

        btnSms.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("sms:")
            intent.putExtra("address", "+998${editPhone.text.toString().trim()}")
            intent.putExtra("sms_body", editMessage.text.toString().trim())
            startActivity(intent)
        }

        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+998${editPhone.text.toString().trim()}")
            startActivity(intent)
        }

        btnSend.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.SEND_SMS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.CALL_PHONE), 100)
            } else {
                sendSms(editPhone.text.toString().trim(), editMessage.text.toString().trim())
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Ruxsat berildi", Toast.LENGTH_SHORT).show()
            sendSms(editPhone.text.toString().trim(), editMessage.text.toString().trim())
        } else {
            Toast.makeText(this, "Ruxsat berilmadi!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendSms(number: String, message: String) {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage("+998$number", null, message, null, null)
        Toast.makeText(this, "Xabar jo'natildi", Toast.LENGTH_SHORT).show()
    }
}