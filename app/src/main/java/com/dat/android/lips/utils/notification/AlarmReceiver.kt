package com.dat.android.lips.utils.notification

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.dat.android.lips.App
import com.dat.android.lips.R
import com.dat.android.lips.presentation.splash.SplashActivity

class AlarmReceiver : BroadcastReceiver() {

    private val CHANNEL_ID =  App.getInstance().applicationContext.packageName // id приложения (build.gradle)


    override fun onReceive(context: Context?, p1: Intent?) {
        val notificationIntent = Intent(context, SplashActivity::class.java)

        val VIBRATE_PATTERN = longArrayOf(0, 500)
        val NOTIFICATION_COLOR = Color.RED
        val NOTIFICATION_SOUND_URI =
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val stackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addNextIntent(notificationIntent)

        val pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = Notification.Builder(context)

        val notification = builder.setContentTitle("")
            .setContentText("")
            .setAutoCancel(true)
            .setVibrate(VIBRATE_PATTERN)
            .setSmallIcon(R.drawable.ic_lips_img)
            .setDefaults(Notification.DEFAULT_SOUND)
            .setSound(NOTIFICATION_SOUND_URI)
            .setContentIntent(pendingIntent)
            .build()

        notification.number = 1


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID)
        }

        val notificationManager =
            context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                context.resources.getString(R.string.app_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build()
            channel.enableLights(true)
            channel.setSound(NOTIFICATION_SOUND_URI, audioAttributes)
            channel.lightColor = NOTIFICATION_COLOR
            channel.vibrationPattern = VIBRATE_PATTERN
            channel.enableVibration(true)
            channel.lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC
            channel.setShowBadge(true)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notification)
    }
}