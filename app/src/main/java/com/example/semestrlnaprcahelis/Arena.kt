package com.example.semestrlnaprcahelis

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Arena  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.arena)

        val superProgressBar: ProgressBar = findViewById(R.id.super_progressBar)
        val postavaProgressBar: ProgressBar = findViewById(R.id.postava_progressBar)
        superProgressBar.max = Super.zivoty
        postavaProgressBar.max = Postava.zivoty
        val postavaCelkoveZivoty = Postava.zivoty

        //Nastavenie zobrazenie atribútov postavy.
        val textMeno = findViewById<TextView>(R.id.text_postava_meno)
        textMeno.text = "Meno: ${Postava.meno}"
        val textUtok = findViewById<TextView>(R.id.text_postava_utok)
        textUtok.text = "Utok: ${Postava.utok}"
        val textObrana = findViewById<TextView>(R.id.text_postava_obrana)
        textObrana.text = "Obrana: ${Postava.obrana}"
        val textZivoty = findViewById<TextView>(R.id.text_postava_zivoty)
        textZivoty.text = "Zivoty: ${Postava.zivoty}"

        //Nastavenie zobrazenie atribútov súpera.
        val textMenoSuper = findViewById<TextView>(R.id.text_super_meno)
        textMenoSuper.text = "Meno: ${Super.meno}"
        val textUtokSuper = findViewById<TextView>(R.id.text_super_utok)
        textUtokSuper.text = "Utok: ${Super.utok}"
        val textObranaSuper = findViewById<TextView>(R.id.text_super_obrana)
        textObranaSuper.text = "Obrana: ${Super.obrana}"
        val textZivotySuper = findViewById<TextView>(R.id.text_super_zivoty)
        textZivotySuper.text = "Zivoty: ${Super.zivoty}"

        //Nastavenie zobrazeného obrázku podľa zvolenej obtiažnosti súpera.
        val imageView = findViewById<ImageView>(R.id.imageView)
        when(Super.obtiaznost) {
            1 -> {imageView.setImageResource(R.drawable.super1)
                imageView.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
                imageView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                imageView.scaleType = ImageView.ScaleType.FIT_CENTER
                val constraints = ConstraintLayout.LayoutParams.WRAP_CONTENT
                val constraintLayout = findViewById<ConstraintLayout>(R.id.constrainLayoutArena)
                val layoutParams = ConstraintLayout.LayoutParams(constraints, constraints)
                layoutParams.startToStart = constraintLayout.id
                layoutParams.endToEnd = constraintLayout.id
                layoutParams.topToTop = constraintLayout.id
                layoutParams.topMargin = 52
                imageView.layoutParams = layoutParams}

            2 -> {imageView.setImageResource(R.drawable.gladiator1)
                imageView.layoutParams.width = 800
                imageView.layoutParams.height = 800
                imageView.scaleType = ImageView.ScaleType.FIT_CENTER

                val layoutParams = imageView.layoutParams as ConstraintLayout.LayoutParams
                layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                layoutParams.topMargin = 40

                imageView.layoutParams = layoutParams
                imageView.requestLayout()}
            3 -> {imageView.setImageResource(R.drawable.gladiator2)
                imageView.layoutParams.width = 800
                imageView.layoutParams.height = 800
                imageView.scaleType = ImageView.ScaleType.FIT_CENTER

                val layoutParams = imageView.layoutParams as ConstraintLayout.LayoutParams
                layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                layoutParams.topMargin = 40

                imageView.layoutParams = layoutParams
                imageView.requestLayout()}
        }

        // Algoritmus na súboj v ktorom sa strieda postava a súper. Kontroluje sa tu aj smrť týchto postáv.
        var counter = 1
            val bojButton = findViewById<Button>(R.id.boj_button)
            bojButton.setOnClickListener  {
                if (counter % 2 == 1) {
                    //Blok pre hráča.
                    if (Super.zablokoval()) {
                        Toast.makeText(this,"Super zablokoval utok!", Toast.LENGTH_SHORT).show()
                    } else {
                        Super.zivoty -= Postava.utok * 3
                        superProgressBar.progress += Postava.utok * 3
                        if(Super.umrel()) {
                            Toast.makeText(this,"Vyhral si!", Toast.LENGTH_LONG).show()
                            Postava.zivoty = postavaCelkoveZivoty
                            Postava.peniaze += 20
                            Postava.body += 1
                            val intent = Intent(this, HlavneMenu::class.java)
                            startActivity(intent)
                        }
                    }
                } else  {
                    //Blok pre súpera.
                    if (Postava.zablokoval()) {
                        Toast.makeText(this,"Zablokoval si utok!", Toast.LENGTH_SHORT).show()
                    } else {
                        Postava.zivoty -= Super.utok * 3
                        postavaProgressBar.progress += Super.utok * 3
                        if(Postava.umrel()) {
                            Postava.peniaze = 50
                            Toast.makeText(this, "Umrel si!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
                counter++
            }
    }
}