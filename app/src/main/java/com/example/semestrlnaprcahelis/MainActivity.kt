package com.example.semestrlnaprcahelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Nastavenie funkčnosti tlačidiel.
        val tutorialButton = findViewById<Button>(R.id.toturial_button)
        tutorialButton.setOnClickListener  {
            val intent = Intent(this, Tutorial::class.java)
            startActivity(intent)
        }

        val zacniButton = findViewById<Button>(R.id.zacni_button)
        zacniButton.setOnClickListener  {
            val intent = Intent(this, VytvoreniePostavy()::class.java)
            startActivity(intent)
        }
    }


}
