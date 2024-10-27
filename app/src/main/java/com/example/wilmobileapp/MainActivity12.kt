package com.example.wilmobileapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity12 : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var etEmail: EditText
    private lateinit var cbCourse1: CheckBox
    private lateinit var cbCourse2: CheckBox
    private lateinit var cbCourse3: CheckBox
    private lateinit var cbCourse4: CheckBox
    private lateinit var cbCourse5: CheckBox
    private lateinit var cbCourse6: CheckBox
    private lateinit var cbCourse7: CheckBox
    private lateinit var btnSubmit: Button

    private val selectedCourses = mutableListOf<String>()
    private var totalFee = 0.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main12)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etName = findViewById(R.id.etName)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etEmail = findViewById(R.id.etEmail)
        cbCourse1 = findViewById(R.id.cbCourse1)
        cbCourse2 = findViewById(R.id.cbCourse2)
        cbCourse3 = findViewById(R.id.cbCourse3)
        cbCourse4 = findViewById(R.id.cbCourse4)
        cbCourse5 = findViewById(R.id.cbCourse5)
        cbCourse6 = findViewById(R.id.cbCourse6)
        cbCourse7 = findViewById(R.id.cbCourse7)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            handleFormSubmission()
        }
    }

    private fun handleFormSubmission() {
        selectedCourses.clear()
        totalFee = 0.0

        val name = etName.text.toString()
        val phoneNumber = etPhoneNumber.text.toString()
        val email = etEmail.text.toString()

        if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill out all contact details", Toast.LENGTH_SHORT).show()
            return
        }

        if (cbCourse1.isChecked) {
            selectedCourses.add("First Aid - R1500")
            totalFee += 1500
        }
        if (cbCourse2.isChecked) {
            selectedCourses.add("Sewing - R1500")
            totalFee += 1500
        }
        if (cbCourse3.isChecked) {
            selectedCourses.add("Landscaping - R1500")
            totalFee += 1500
        }
        if (cbCourse4.isChecked) {
            selectedCourses.add("Life Skills - R1500")
            totalFee += 1500
        }
        if (cbCourse5.isChecked) {
            selectedCourses.add("Child Minding - R750")
            totalFee += 750
        }
        if (cbCourse6.isChecked) {
            selectedCourses.add("Cooking - R750")
            totalFee += 750
        }
        if (cbCourse7.isChecked) {
            selectedCourses.add("Garden Maintenance - R750")
            totalFee += 750
        }

        if (selectedCourses.isEmpty()) {
            Toast.makeText(this, "Please select at least one course", Toast.LENGTH_SHORT).show()
            return
        }

        val discountPercentage = when (selectedCourses.size) {
            1 -> 0
            2 -> 5
            3 -> 10
            else -> 15
        }

        val discountAmount = totalFee * discountPercentage / 100
        val finalFee = totalFee - discountAmount

        val intent = Intent(this, MainActivity13::class.java).apply {
            putExtra("name", name)
            putExtra("phoneNumber", phoneNumber)
            putExtra("email", email)
            putExtra("selectedCourses", ArrayList(selectedCourses))
            putExtra("totalFee", totalFee)
            putExtra("discountPercentage", discountPercentage)
            putExtra("discountAmount", discountAmount)
            putExtra("finalFee", finalFee)
        }
        startActivity(intent)

    }
}
