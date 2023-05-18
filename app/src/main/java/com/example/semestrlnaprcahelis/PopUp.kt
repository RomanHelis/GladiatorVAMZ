package com.example.semestrlnaprcahelis
import android.annotation.SuppressLint
import android.content.Context
import android.view.*
import android.widget.PopupWindow


class PopUp(private val context: Context) {
    //Atribút triedy
    private var vyskakovacieOkno: PopupWindow? = null

    @SuppressLint("ClickableViewAccessibility")

    //Metóda na zobrazenie vyskakovacieho okna
    fun showPopup(zobrazenie: View) {
        val inf = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popUp = inf.inflate(R.layout.pop_up, null)

        //Vytvorenie vyskakovacieho okna
        vyskakovacieOkno = PopupWindow(
            popUp,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        // Nastaví polohu kde sa zobrazí vyskakovacie okno a kontroluje či ho hráč zavrel
        vyskakovacieOkno?.showAtLocation(zobrazenie, Gravity.CENTER, 0, 0)
        popUp.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_OUTSIDE) {
                zavriOkno()
                true
            } else false
        }
    }

    //Metóda na zavretie vyskakovacieho okna
    private fun zavriOkno() {
        vyskakovacieOkno?.dismiss()
        vyskakovacieOkno = null
    }
}