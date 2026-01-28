package com.mk.vitaltrack.application

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.mk.vitaltrack.worker.VitalWorker
import java.util.concurrent.TimeUnit

class VitalTrack : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        scheduleVitalsReminder()
    }

    private fun scheduleVitalsReminder() {
        val workRequest = PeriodicWorkRequestBuilder<VitalWorker>(5, TimeUnit.HOURS)
            .build()
//  Application context always exists as long as the app package is in memory.
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "VitalsReminderWorkAd",
            ExistingPeriodicWorkPolicy.KEEP,
            workRequest
        )
    }

//    private fun scheduleVitalsReminder() {
//        val testWork = OneTimeWorkRequestBuilder<VitalWorker>().build()
//        WorkManager.getInstance(this).enqueue(testWork)
//    }


    private fun createNotificationChannel() {
        val name  = "Vitals Reminder"
        val descriptionText = "Reminds the mother to log pregnancy vitals"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel("vitals_log",name,importance)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}