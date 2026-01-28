package com.mk.vitaltrack.data.repository

import com.mk.vitaltrack.data.local.VitalsDao
import com.mk.vitaltrack.data.local.toUiModel
import com.mk.vitaltrack.domain.model.VitalUiModel
import com.mk.vitaltrack.domain.model.VitalsInputModel
import com.mk.vitaltrack.domain.model.toVitalEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VitalsRepository(
    private val dao : VitalsDao
) {

    val vitalsUiFlow  :  Flow<List<VitalUiModel>> =  dao.observeVitals()
        .map { list -> list.map{ it.toUiModel() } }

    suspend fun submitVitals(input: VitalsInputModel){
        dao.insertVitals(input
            .toVitalEntity())
    }
}