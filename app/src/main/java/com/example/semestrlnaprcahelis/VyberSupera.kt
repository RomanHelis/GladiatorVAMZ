package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class VyberSupera: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vyber_supera)

        //Zadefinovanie funkčností tlačidiel.
        val super1ImageButton: ImageButton = findViewById(R.id.super1_imageButton)
        super1ImageButton.setOnClickListener {
            Super.urciObtiaznostSupera(1)
            val intent = Intent(this, Arena::class.java)
            startActivity(intent)
        }

        val super2ImageButton: ImageButton = findViewById(R.id.super2_imageButton)
        super2ImageButton.setOnClickListener {
            Super.urciObtiaznostSupera(2)
            val intent = Intent(this, Arena::class.java)
            startActivity(intent)
        }

        val super3ImageButton: ImageButton = findViewById(R.id.super3_imageButton)
        super3ImageButton.setOnClickListener {
            Super.urciObtiaznostSupera(3)
            val intent = Intent(this, Arena::class.java)
            startActivity(intent)
        }

        val koniecButton = findViewById<Button>(R.id.exit_button)
        koniecButton.setOnClickListener  {
            val intent = Intent(this, HlavneMenu::class.java)
            startActivity(intent)

        }
    }
}