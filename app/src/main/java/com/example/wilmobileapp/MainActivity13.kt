package com.example.wilmobileapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity13 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main13)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<Button>(R.id.button15)
        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val email = intent.getStringExtra("email")
        val selectedCourses = intent.getStringArrayListExtra("selectedCourses")
        val totalFee = intent.getDoubleExtra("totalFee", 0.0)
        val discountPercentage = intent.getIntExtra("discountPercentage", 0)
        val discountAmount = intent.getDoubleExtra("discountAmount", 0.0)
        val finalFee = intent.getDoubleExtra("finalFee", 0.0)

        val textView = findViewById<TextView>(R.id.textViewSummary)
        textView.text = """
            Name: $name
            Phone: $phoneNumber
            Email: $email
            Courses: $selectedCourses
            Total Fee: R$totalFee
            Discount: $discountPercentage% (R$discountAmount)
            Final Total: R$finalFee
        """.trimIndent()

        backButton?.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}
