package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class VytvoreniePostavy()  : AppCompatActivity() {
    private lateinit var popUpMiesto: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vytvorenie_postavy)
        Postava.vypisAtributy()

        //Nastavenie SeekBarov a ich hodnôt.
        val sliderUtok = findViewById<SeekBar>(R.id.slider_utok)
        val sliderUtokValue = findViewById<TextView>(R.id.slider_utok_value)
        val sliderObrana = findViewById<SeekBar>(R.id.slider_obrana)
        val sliderObranaValue = findViewById<TextView>(R.id.slider_obrana_value)
        val sliderZivoty = findViewById<SeekBar>(R.id.slider_zivoty)
        val sliderZivotyValue = findViewById<TextView>(R.id.slider_zivoty_value)

        //Získanie hodnoty zo SeekBaru a nastavenie atribútu z neho.
        sliderUtok.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Postava.nastavUtok(progress)
                sliderUtokValue.text = "Zvolená hodnota: $progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //Získanie hodnoty zo SeekBaru a nastavenie atribútu z neho.
        sliderObrana.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Postava.nastavObranu(progress)
                sliderObranaValue.text = "Zvolená hodnota: $progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //Získanie hodnoty zo SeekBaru a nastavenie atribútu z neho.
        sliderZivoty.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Postava.nastavZivoty(progress)
                sliderZivotyValue.text = "Zvolená hodnota: $progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //Nastavenie tlačidla pre ukončenie aktivity.
        val koniecButton = findViewById<Button>(R.id.koniec_button)
        koniecButton.setOnClickListener  {
            val zadanyText = findViewById<EditText>(R.id.menoPostavy)
            val zadaneMeno = zadanyText.text.toString()
            if (Postava.kontrolaAtributov()) {
                if (zadaneMeno.isNotEmpty()) {
                    println(zadaneMeno)
                    Postava.nastavMeno(zadaneMeno)
                } else {
                    Postava.nastavMeno("Gladiátor")
                }
                Postava.navysAtributy()
                val intent = Intent(this, HlavneMenu::class.java)
                startActivity(intent)
            } else {
                //Ak nastavený počet atribítov hráča presahuje 10, vyskočí vyskakovacie okno.
                fun onWindowFocusChanged(hasFocus: Boolean) {
                    super.onWindowFocusChanged(hasFocus)
                    if (hasFocus) {
                        val popupWindow = PopUp(this)
                        popupWindow.showPopup(koniecButton)
                    }
                }
                onWindowFocusChanged(hasFocus = true)
                sliderUtok.progress = 1
                sliderObrana.progress = 1
                sliderZivoty.progress = 1
            }
        }
    }
}