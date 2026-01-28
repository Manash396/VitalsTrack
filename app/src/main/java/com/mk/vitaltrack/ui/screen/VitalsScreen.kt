package com.mk.vitaltrack.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.mk.vitaltrack.ui.viewmodel.VitalsViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.mk.vitaltrack.ui.components.VitalCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VitalsScreen(viewModel: VitalsViewModel) {

    val vitals by viewModel.vitals.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Track My Pregnancy" , style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffc6adfc),
                    titleContentColor = Color(0xff6827a5)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true },
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(vitals) { vital ->
                VitalCard( vital)
            }
        }
    }

    if (showDialog) {
        AddVitalsDialog(
            onDismiss = { showDialog = false },
            onSubmit = {
                viewModel.onSubmitVitals(it)
                showDialog = false
            }
        )
    }
}

