package com.mk.vitaltrack.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mk.vitaltrack.notification.NotificationHelper

class VitalWorker (
    context: Context,
    workParams: WorkerParameters
) : CoroutineWorker(context,workParams){

    override suspend fun doWork(): Result {

        NotificationHelper.sendVitalsReminderNotification(applicationContext)
        return Result.Success()
    }

}