package com.example.semestrlnaprcahelis
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Tutorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tutorial)

        //Tlačidlo ktoré vráti hráča späť na začiatok hry.
        val koniecButton = findViewById<Button>(R.id.exit_button)
        koniecButton.setOnClickListener  {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}