package com.mk.vitaltrack.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mk.vitaltrack.data.local.DatabaseProvider
import com.mk.vitaltrack.data.repository.VitalsRepository

class VitalsViewModelFactory(
    context: Context
) : ViewModelProvider.Factory {

    private val dao  = DatabaseProvider.provideDao(context)

    private val repo = VitalsRepository(dao)

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VitalsViewModel::class.java)) {
            return VitalsViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }


}