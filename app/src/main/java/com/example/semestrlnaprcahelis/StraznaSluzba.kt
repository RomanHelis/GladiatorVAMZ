package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class StraznaSluzba  : AppCompatActivity() {

    private lateinit var timer: CountDownTimer
    private var sekundy: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.strazca)

        //Nastavenie potvrdzovacieho tlačidla.
        val potvrditButton = findViewById<Button>(R.id.potvrdit_button)
        potvrditButton.setOnClickListener {
            val zadanyText = findViewById<EditText>(R.id.editTextPocetSekund)
            val zadaneCislo = zadanyText.text.toString()
            sekundy = zadaneCislo.toLongOrNull() ?: 0
            sekundy *= 1000
            Casovac.zacni(sekundy, this, "Strážna služba skončila!")
        }

        //Nastavenie ukončovacieho tlačidla.
        val koniecButton = findViewById<Button>(R.id.exit_button)
        koniecButton.setOnClickListener {
            val intent = Intent(this, HlavneMenu()::class.java)
            startActivity(intent)
        }

        //Nastavenie tlačidla, ktoré zistí, či má hráč niečo odpracované, ak áno mu to vyplatí.
        val odmenaButton = findViewById<Button>(R.id.odmena_button)
        odmenaButton.setOnClickListener {
            if (Casovac.odmena > 0) {
                Postava.peniaze += Casovac.odmena
                val odmena = Casovac.odmena
                Toast.makeText(this,"Zarobený počet mincí: $odmena!", Toast.LENGTH_SHORT).show()
                Casovac.odmena = 0
            } else  {
                //Ak hráč nemá nič odpracované, vypíše sa správa.
                Toast.makeText(this,"Ešte ste nepracovali!", Toast.LENGTH_SHORT).show()
            }

        }
    }

}