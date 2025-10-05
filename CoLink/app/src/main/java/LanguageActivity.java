package com.fikile.colink

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupLanguages)
                val btnNext = findViewById<ImageButton>(R.id.btn_next)

                // Default to English if present
                radioGroup.check(R.id.radio_english)

        btnNext.setOnClickListener {
            val checkedId = radioGroup.checkedRadioButtonId
            if (checkedId == -1) {
                Toast.makeText(this, "Please select a language", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val selectedRadio = findViewById<RadioButton>(checkedId)
                    val language = selectedRadio.text.toString()

            val intent = Intent(this, AgreeActivity::class.java).apply {
                putExtra("selected_language", language)
            }
            startActivity(intent)
        }
    }
}

