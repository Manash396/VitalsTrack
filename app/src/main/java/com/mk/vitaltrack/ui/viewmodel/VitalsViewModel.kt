package com.mk.vitaltrack.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.vitaltrack.data.repository.VitalsRepository
import com.mk.vitaltrack.domain.model.VitalsInputModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VitalsViewModel(
    private val repo: VitalsRepository
) : ViewModel(){

    // it stays alive until the viewmodel and stops after 5 sec if there no view lifecycle collector

     val vitals  = repo.vitalsUiFlow.stateIn(
         viewModelScope,
         SharingStarted.WhileSubscribed(5_000),
         emptyList()
     )

    fun onSubmitVitals(input : VitalsInputModel){
        viewModelScope.launch {
            repo.submitVitals(input)
        }
    }
}