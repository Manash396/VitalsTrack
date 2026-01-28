package com.mk.vitaltrack.domain.model

data class VitalUiModel(
    val id: Long,
    val bpText: String,
    val heartRateText: String,
    val weightText: String,
    val kicksText: String,
    val dateTimeText: String
)

