package com.example.wilmobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val faButton = findViewById<Button>(R.id.button6)
        val sewButton = findViewById<Button>(R.id.button7)
        val lsButton = findViewById<Button>(R.id.button8)
        val skillsButton = findViewById<Button>(R.id.button9)
        val cmButton = findViewById<Button>(R.id.button10)
        val cookButton = findViewById<Button>(R.id.button11)
        val gmButton = findViewById<Button>(R.id.button12)
        val contactButton = findViewById<Button>(R.id.button5)
        val calcButton = findViewById<Button>(R.id.button13)

        contactButton?.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        faButton?.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

        sewButton?.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        lsButton?.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        skillsButton?.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }

        cmButton?.setOnClickListener {
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }

        cookButton?.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }

        gmButton?.setOnClickListener {
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
        }

        calcButton?.setOnClickListener {
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }
    }
}