package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HlavneMenu  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hlavne_menu)

        //Nastavenie zobrazenia atribútov hráča.
        val textMeno = findViewById<TextView>(R.id.text_meno)
        textMeno.text = "Meno: ${Postava.meno}"
        val textUtok = findViewById<TextView>(R.id.text_utok)
        textUtok.text = "Utok: ${Postava.utok}"
        val textObrana = findViewById<TextView>(R.id.text_obrana)
        textObrana.text = "Obrana: ${Postava.obrana}"
        val textZivoty = findViewById<TextView>(R.id.text_zivoty)
        textZivoty.text = "Zivoty: ${Postava.zivoty}"
        val textPeniaze = findViewById<TextView>(R.id.text_peniaze)
        textPeniaze.text = "Mince: ${Postava.peniaze}"

        //Nastavenie funkčnosti tlačidiel.
        val arenaButton = findViewById<Button>(R.id.arena_button)
        arenaButton.setOnClickListener  {
            if(Casovac.bezi == 0) {
                val intent = Intent(this, VyberSupera::class.java)
                startActivity(intent)
            } else  {
                Toast.makeText(this,"Teraz ste na strážnej službe!", Toast.LENGTH_SHORT).show()
            }
        }

        val obchodZbraneButton = findViewById<Button>(R.id.obchod_so_zbranami_button)
        obchodZbraneButton.setOnClickListener  {
            val intent = Intent(this, ObchodSoZbranami::class.java)
            startActivity(intent)

        }

        val obchodBrnenieButton = findViewById<Button>(R.id.obchod_s_brnenim_button)
        obchodBrnenieButton.setOnClickListener  {
            val intent = Intent(this, ObchodSBrnenim::class.java)
            startActivity(intent)

        }

        val straznaSluzbaButton = findViewById<Button>(R.id.strazna_sluzba_button)
        straznaSluzbaButton.setOnClickListener  {
            val intent = Intent(this, StraznaSluzba::class.java)
            startActivity(intent)

        }

        val bodyButton = findViewById<Button>(R.id.body_button)
        bodyButton.setOnClickListener  {
            if (Postava.body > 0) {
                val intent = Intent(this, AlokujBody::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Nemáš voľné skúsenostné body!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}