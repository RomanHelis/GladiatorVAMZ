package com.example.semestrlnaprcahelis
import kotlin.random.Random

object Postava {
    //Atribúty objektu postava.
    var meno: String = "Gladiátor"
    var utok: Int = 1
    var obrana: Int = 1
    var zivoty: Int = 1
    var peniaze: Int = 50
    var brnenie: Int = 0
    var zbran: Int = 0
    var body: Int = 0

    fun vypisAtributy() {
        println("$meno $utok $obrana $zivoty")
    }

    fun nastavUtok(arg: Int) {
        utok = arg
    }

    fun zoberZbran() {
        utok -= zbran
        zbran = 0
    }

    fun zoberBrnenie() {
        obrana -= brnenie
        brnenie = 0
    }

    fun nastavBrnenie(arg: Int) {
        brnenie = arg
        obrana += brnenie
    }

    fun nastavZbran(arg: Int) {
        zbran = arg
        utok += zbran
    }

    fun maZbran(): Boolean {
        if(zbran > 0) {
            return true
        }
        return false
    }

    fun maBrnenie(): Boolean {
        if(brnenie > 0) {
            return true
        }
        return false
    }

    fun nastavObranu(arg: Int) {
        obrana = arg
    }

    fun nastavZivoty(arg: Int) {
        zivoty = arg
    }

    fun nastavMeno(arg: String) {
        println(meno)
        meno = arg
    }

    //Metóda kontroluje hodnotu všetkých atribútov a ak presahuje 10 vráti false.
    fun kontrolaAtributov(): Boolean {
        val spolu = utok + obrana + zivoty
        if (spolu > 10) {
            return false
        }
        return true
    }

    fun navysAtributy() {
        zivoty *= 10
    }

    //Metóda kontroluje dostatok peňazí hráča, ak je dostatok peňazí ich rovno odpočíta z atribútu.
    fun dostatokPenazi(arg: Int): Boolean {
        if (arg <= peniaze) {
            peniaze -= arg
            return true
        }
        return false
    }

    //Metóda kontroluje či hráč umrel podľa atribútu životy.
    fun umrel(): Boolean {
        if (zivoty <= 0) {
            return true
        }
        return false
    }

    //Metóda kontroluje či hráč zablokoval úder podľa atribútu obrana a náhody.
    fun zablokoval(): Boolean {
        val zablokovanie = obrana * 5
        val nahoda = Random.nextInt(1, 101)
        if (zablokovanie > nahoda) {
            return true
        }
        return false
    }

}