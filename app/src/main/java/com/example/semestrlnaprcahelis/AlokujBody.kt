package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class AlokujBody : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alokuj_body)

        //Tu sa zistí zvolená možnosť a podľa nej sa pridá bod do zvoleného atribútu.
        val potvrditButton = findViewById<Button>(R.id.potvrdit_button)
        potvrditButton.setOnClickListener {
            val radioGroup: RadioGroup = findViewById(R.id.body_options)
            val zvoleneRadioButtonId = radioGroup.checkedRadioButtonId
            val zvolenyRadioButton: RadioButton = findViewById(zvoleneRadioButtonId)
            when (zvolenyRadioButton.text.toString()) {
                "Útok" ->  {Postava.utok += 1
                            Postava.body -= 1
                            val intent = Intent(this, HlavneMenu::class.java)
                            startActivity(intent)
                }
                "Obrana"-> {Postava.obrana += 1
                            Postava.body -= 1
                            val intent = Intent(this, HlavneMenu::class.java)
                            startActivity(intent)
                }
                "Životy"-> {Postava.zivoty += 10
                            Postava.body -= 1
                            val intent = Intent(this, HlavneMenu::class.java)
                            startActivity(intent)
                }
            }
        }
    }
}