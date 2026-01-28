package com.mk.vitaltrack.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mk.vitaltrack.domain.model.VitalUiModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = "vitals")
data class VitalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    val systolicBp: Int,
    val diastolicBp: Int,

    val heartRateBpm: Int,
    val weightKg: Int,
    val babyKicks: Int,

    val recordedAt : Long = System.currentTimeMillis()
)

fun VitalEntity.toUiModel(): VitalUiModel {
   return VitalUiModel(
        id = id,
       bpText = "$systolicBp/$diastolicBp mmHg",
       heartRateText = "$heartRateBpm bpm",
       weightText =  "$weightKg Kg",
       kicksText = "$babyKicks kicks",
       dateTimeText = formatDate(recordedAt)
   )
}


    fun formatDate(recordedAt: Long): String{
        val sdf  = SimpleDateFormat("EEE, dd MMM  yyyy h:mm a", Locale.US)
        val date  = Date(recordedAt)
        return  sdf.format(date)
}


