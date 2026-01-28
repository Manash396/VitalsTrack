package com.mk.vitaltrack.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mk.vitaltrack.notification.NotificationHelper

class VitalWorker (
    context: Context,
    workParams: WorkerParameters
) : CoroutineWorker(context,workParams){

    override suspend fun doWork(): Result {

        Log.e("Krishna", "🔥 WORKER EXECUTED 🔥")
        NotificationHelper.sendVitalsReminderNotification(applicationContext)
        return Result.success()
    }

}