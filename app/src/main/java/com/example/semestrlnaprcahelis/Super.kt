package com.example.semestrlnaprcahelis

import kotlin.random.Random

object Super {
    //Atribúty objektu Super.
    var meno: String = "Gladiator"
    var utok: Int = 1
    var obrana: Int = 1
    var zivoty: Int = 1
    var obtiaznost: Int = 0

    //Metóda, ktorá generuje čislo 1, alebo -1
    fun generujCislo(): Int {
        val rand = Random.nextInt(2)
        return if (rand == 0) -1 else 1
    }

    //Metóda, ktorá meni atribúty podľa argumentu a náhodnej hodnoty
    fun zmenAtributy(arg:Int) {
        utok = arg + generujCislo()
        obrana = arg + generujCislo()
        zivoty = arg * 10 + generujCislo() * 10
    }

    //Metóda, ktorá určí atribút obtiažnosť a zavolá metódu zmenAtributy
    fun urciObtiaznostSupera(arg: Int) {
        obtiaznost = arg
        when (arg) {
            1 -> zmenAtributy(3)
            2 -> zmenAtributy(5)
            3 -> zmenAtributy(8)
        }
    }

    //Metóda kontroluje či súper umrel podľa atribútu životy.
    fun umrel(): Boolean {
        if (zivoty <= 0) {
            return true
        }
        return false
    }

    //Metóda kontroluje či súper zablokoval úder podľa atribútu obrana a náhody.
    fun zablokoval(): Boolean {
        val zablokovanie = Postava.obrana * 5
        val nahoda = Random.nextInt(1, 101)
        if (zablokovanie > nahoda) {
            return true
        }
        return false
    }
}
