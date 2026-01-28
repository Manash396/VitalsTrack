package com.mk.vitaltrack.domain.model

import com.mk.vitaltrack.data.local.VitalEntity
import kotlin.Int

data class VitalsInputModel(
    val systolicBp: String = "",
    val diastolicBp: String = "",
    val heartRate: String = "",
    val weight: String = "",
    val babyKicks: String = ""
)

fun VitalsInputModel.toVitalEntity(): VitalEntity {
    return VitalEntity(
        systolicBp =  systolicBp.toInt(),
        diastolicBp = diastolicBp.toInt() ,
        heartRateBpm =heartRate.toInt() ,
        weightKg = weight.toInt(),
        babyKicks = babyKicks.toInt(),
    )
}
