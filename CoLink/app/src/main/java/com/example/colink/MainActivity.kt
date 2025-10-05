package com.fikile.colink

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val root = findViewById<ConstraintLayout>(R.id.root_landing)
        // Tap anywhere to go to language screen
        root.setOnClickListener {
            startActivity(Intent(this, LanguageActivity::class.java))
        }
    }
}
