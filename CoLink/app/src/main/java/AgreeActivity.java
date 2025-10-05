package com.fikile.colink

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AgreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agree)

        val spinner = findViewById<Spinner>(R.id.spinner_language)
                val agreeBtn = findViewById<Button>(R.id.btn_agree)

                // Load languages from resources
                val languages = resources.getStringArray(R.array.language_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Pre-select language if passed from previous screen
        val passed = intent.getStringExtra("selected_language")
        if (passed != null) {
            val index = languages.indexOf(passed)
            if (index >= 0) spinner.setSelection(index)
        }

        agreeBtn.setOnClickListener {
            val chosen = spinner.selectedItem?.toString() ?: "English"
            Toast.makeText(this, "Agreed, continuing with $chosen", Toast.LENGTH_SHORT).show()
            // Here you would continue to the main app. For now finish this flow:
            finishAffinity() // close the demo flow
        }
    }
}

