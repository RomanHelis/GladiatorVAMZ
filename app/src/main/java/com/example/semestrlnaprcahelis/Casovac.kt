package com.example.semestrlnaprcahelis

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


object Casovac {
    //Atribúty objektu Casovac.
    private lateinit var timer: CountDownTimer
    private const val CHANNEL_ID = "channel_id_example"
    private const val notificationId = 101
    var odmena = 0
    var bezi = 0
    var vyrobenaZbran = 0
    var vyrabamZbran = 0

    //Metóda pre vytvorenie notifikácie, odštartovaní časovača pre stráženie.
    fun zacni(arg: Long, context: Context, sprava: String) {
        createNotificationChannel(context)
        timer = object : CountDownTimer(arg, 3000) {
            override fun onTick(remainingMillis: Long) {
                bezi = 1
            }
            override fun onFinish() {
                sendNotification(context, sprava)
                println(arg)
                println(odmena)
                odmena = (arg / 5).toInt() / 1000
                bezi = 0
            }
        }
        timer.start()
    }

    //Metóda pre vytvorenie notifikácie, odštartovaní časovača pre vyrábanie zbrane.
    fun zacniRobitZbran(arg: Long, context: Context, zbran: Int , sprava: String) {
        createNotificationChannel(context)
        timer = object : CountDownTimer(arg, 3000) {
            override fun onTick(remainingMillis: Long) {
                vyrabamZbran = 1
            }
            override fun onFinish() {
                sendNotification(context, sprava)
                vyrabamZbran = 0
                vyrobenaZbran = zbran
            }
        }
        timer.start()
    }

    //Metóda pre vytvorenie notifikácie.
    private fun sendNotification(context: Context, sprava: String) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.character)
            .setContentTitle("Gladiator")
            .setContentText(sprava)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(notificationId, builder.build())
        }
    }

    //Metóda pre vytvorenie notifikačného kanálu.
    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification"
            val descriptionText = "Notification description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}