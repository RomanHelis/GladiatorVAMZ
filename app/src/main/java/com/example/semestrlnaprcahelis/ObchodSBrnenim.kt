package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ObchodSBrnenim : AppCompatActivity() {
    private lateinit var buttonView: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.obchod_s_brnenim)

        buttonView = findViewById<Button>(R.id.exit_button)

        val textMeno = findViewById<TextView>(R.id.text_meno)
        textMeno.text = "Meno: ${Postava.meno}"
        val textPeniaze = findViewById<TextView>(R.id.text_peniaze)
        textPeniaze.text = "Mince: ${Postava.peniaze}"

        val koniecButton = findViewById<Button>(R.id.exit_button)
        koniecButton.setOnClickListener  {
            val intent = Intent(this, HlavneMenu::class.java)
            startActivity(intent)
        }

        val kupitButton = findViewById<Button>(R.id.kupit_button)
        kupitButton.setOnClickListener  {
            kupaBrnenia()
        }
    }

    //Metóda na zistenie zvolenej možnosti a podľa nej sa kúpi zvolené brnenie, ak má hráč dostatok mincí.
    private fun kupaBrnenia() {
        val radioGroup: RadioGroup = findViewById(R.id.brnenie_options)
        val zvoleneRadioButtonId = radioGroup.checkedRadioButtonId
        val zvolenyRadioButton: RadioButton = findViewById(zvoleneRadioButtonId)
        val zvolenaVolba = zvolenyRadioButton.text.toString()
        when (zvolenaVolba) {
            "Kožené brnenie" -> if (Postava.dostatokPenazi(10)){
                if (Postava.maBrnenie()) {
                    Postava.zoberBrnenie()
                    Postava.nastavBrnenie(1)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else  {
                    Postava.nastavBrnenie(1)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                }
            } else {
                //Ak hráč nemá dostatok mincí, vytvorí sa vyskakovacie okno.
                fun onWindowFocusChanged(hasFocus: Boolean) {
                    super.onWindowFocusChanged(hasFocus)
                    if (hasFocus) {
                        val popupWindow = PopUp(this)
                        popupWindow.showPopup(buttonView)
                    }
                }
                onWindowFocusChanged(hasFocus = true)
            }
            "Ocelové brnenie"-> if (Postava.dostatokPenazi(50)){
                if (Postava.maBrnenie()) {
                    Postava.zoberBrnenie()
                    Postava.nastavBrnenie(3)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else {
                    Postava.nastavBrnenie(3)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                }
            } else {
                //Ak hráč nemá dostatok mincí, vytvorí sa vyskakovacie okno.
                fun onWindowFocusChanged(hasFocus: Boolean) {
                    super.onWindowFocusChanged(hasFocus)
                    if (hasFocus) {
                        val popupWindow = PopUp(this)
                        popupWindow.showPopup(buttonView)
                    }
                }
                onWindowFocusChanged(hasFocus = true)
            }
            "Titánové brnenie" -> if (Postava.dostatokPenazi(100)){
                if (Postava.maBrnenie()) {
                    Postava.zoberBrnenie()
                    Postava.nastavBrnenie(5)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else {
                    Postava.nastavBrnenie(5)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                }
            } else {
                fun onWindowFocusChanged(hasFocus: Boolean) {
                    super.onWindowFocusChanged(hasFocus)
                    if (hasFocus) {
                        val popupWindow = PopUp(this)
                        popupWindow.showPopup(buttonView)
                    }
                }
                onWindowFocusChanged(hasFocus = true)
            }
        }
        println("Zvolená možnosť: $zvolenaVolba")
    }
}