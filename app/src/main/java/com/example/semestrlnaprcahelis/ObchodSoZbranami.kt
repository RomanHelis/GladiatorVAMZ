package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ObchodSoZbranami : AppCompatActivity() {

    //Atribút triedy.
    private lateinit var buttonView: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.obchod_so_zbranami)


        //Nastavenie zobrazenia atribútov hráča.
        val textMeno = findViewById<TextView>(R.id.text_meno)
        textMeno.text = "Meno: ${Postava.meno}"
        val textPeniaze = findViewById<TextView>(R.id.text_peniaze)
        textPeniaze.text = "Mince: ${Postava.peniaze}"

        //Nastavenie tlačidiel.
        buttonView = findViewById<Button>(R.id.exit_button)
        buttonView.setOnClickListener  {
            val intent = Intent(this, HlavneMenu::class.java)
            startActivity(intent)
        }

        val kupitButton = findViewById<Button>(R.id.kupit_button)
        kupitButton.setOnClickListener  {
            kupaZbrane()
        }

        val vyrobitButton = findViewById<Button>(R.id.vyrobit_button)
        vyrobitButton.setOnClickListener  {
            vyrobaZbrane()
        }

        //Tlačidlo vyzdvihniButton, ktoré zisťuje či je vyrobená zbraň
        val vyzdvihniButton = findViewById<Button>(R.id.vyzdvihni_button)
        vyzdvihniButton.setOnClickListener  {
            if (Casovac.vyrobenaZbran > 0) {
                //Ak je vyrobená zbraň, nastaví ju hráčovi.
                Postava.zoberZbran()
                Postava.nastavZbran(Casovac.vyrobenaZbran)
                Casovac.vyrobenaZbran = 0
                Toast.makeText(this,"Zbraň vyzdvihnutá!", Toast.LENGTH_SHORT).show()
            } else {
                //Ak nie je vyrobená zbraň, zobrazí správu.
                Toast.makeText(this,"Nemáč čo vyzdvihnúť!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Metóda na výrobu zbraní, ktorá kontroluje či má hráč dostatok peňazí a volá objekt Casovac ak má hráč dostatok peňazí ak nie zobrazí vyskakovacie okno
    private fun vyrobaZbrane() {

        val radioGroup: RadioGroup = findViewById(R.id.zbrane_options)
        val zvoleneRadioButtonId = radioGroup.checkedRadioButtonId
        val zvolenyRadioButton: RadioButton = findViewById(zvoleneRadioButtonId)
        val zvolenaVolba = zvolenyRadioButton.text.toString()
        when (zvolenaVolba) {
            "Palica" -> if (Postava.dostatokPenazi(5)){
                if (Casovac.vyrabamZbran == 0) {
                    Casovac.zacniRobitZbran(30000, this, 1, "Výroba zbrane skončila!")
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else  {
                    Toast.makeText(this,"Už vyrábaš zbraň!", Toast.LENGTH_SHORT).show()
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
            "Sekera"-> if (Postava.dostatokPenazi(25)){
                if (Casovac.vyrabamZbran == 0) {
                    Casovac.zacniRobitZbran(30000, this, 2, "Výroba zbrane skončila!")
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else  {
                    Toast.makeText(this,"Už vyrábaš zbraň!", Toast.LENGTH_SHORT).show()
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
            "Meč" -> if (Postava.dostatokPenazi(50)){
                if (Casovac.vyrabamZbran == 0) {
                    Casovac.zacniRobitZbran(30000, this, 3, "Výroba zbrane skončila!")
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else  {
                    Toast.makeText(this,"Už vyrábaš zbraň!", Toast.LENGTH_SHORT).show()
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

    //Metóda na kúpu zbraní, ktorá kontroluje či má hráč dostatok peňazí
    //V prípade, že áno zbraň kúpi a hráčovi ju dá, ak nie zobrazí vyskakovacie okno
    private fun kupaZbrane() {
        val radioGroup: RadioGroup = findViewById(R.id.zbrane_options)
        val zvoleneRadioButtonId = radioGroup.checkedRadioButtonId
        val zvolenyRadioButton: RadioButton = findViewById(zvoleneRadioButtonId)
        val zvolenaVolba = zvolenyRadioButton.text.toString()
        when (zvolenaVolba) {
            "Palica" -> if (Postava.dostatokPenazi(10)){
                if (Postava.maZbran()) {
                    Postava.zoberZbran()
                    Postava.nastavZbran(1)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else  {
                    Postava.nastavZbran(1)
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
            "Sekera"-> if (Postava.dostatokPenazi(50)){
                if (Postava.maZbran()) {
                    Postava.zoberZbran()
                    Postava.nastavZbran(3)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else  {
                    Postava.nastavZbran(3)
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
            "Meč" -> if (Postava.dostatokPenazi(100)){
                if (Postava.maZbran()) {
                    Postava.zoberZbran()
                    Postava.nastavZbran(5)
                    val intent = Intent(this, HlavneMenu::class.java)
                    startActivity(intent)
                } else  {
                    Postava.nastavZbran(5)
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