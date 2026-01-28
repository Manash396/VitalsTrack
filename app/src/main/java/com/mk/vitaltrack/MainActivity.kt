package com.mk.vitaltrack

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import android.graphics.Color
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.mk.vitaltrack.ui.screen.VitalsScreen
import com.mk.vitaltrack.ui.theme.VitalTrackTheme
import com.mk.vitaltrack.ui.viewmodel.VitalsViewModel
import com.mk.vitaltrack.ui.viewmodel.VitalsViewModelFactory

class MainActivity : ComponentActivity() {

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light( // 👈 use LIGHT
                scrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT
            )
        )


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                notificationPermissionLauncher.launch(
                    Manifest.permission.POST_NOTIFICATIONS
                )
            }
        }

        val viewModelFactory = VitalsViewModelFactory(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[VitalsViewModel::class.java]


        setContent {
            VitalTrackTheme {
                VitalsScreen(viewModel)
            }
        }
    }
}

