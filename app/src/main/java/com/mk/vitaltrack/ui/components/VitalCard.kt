package com.mk.vitaltrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChildCare
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MonitorHeart
import androidx.compose.material.icons.outlined.Scale
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mk.vitaltrack.domain.model.VitalUiModel


@Composable
fun VitalCard(vital: VitalUiModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = Color(0xFFeab8ff))
        ) {

            // Row 1: Heart rate & BP
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {

                VitalItem(
                    icon = Icons.Outlined.Favorite,
                    text = vital.heartRateText,
                    modifier = Modifier.weight(1f)
                )
                VitalItem(
                    icon = Icons.Outlined.MonitorHeart,
                    text = vital.bpText,
                    modifier = Modifier.weight(1f)
                )
            }


            // Row 2: Weight & Kicks
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                VitalItem(
                    icon = Icons.Outlined.Scale,
                    text = vital.weightText,
                    modifier = Modifier.weight(1f)
                )
                VitalItem(
                    icon = Icons.Outlined.ChildCare,
                    text = vital.kicksText, modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))


            // Date & time
            // Date & time in a colored box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer, // choose any color you like
                    )
                    .padding(horizontal = 8.dp, vertical = 10.dp) // padding inside the box
            ) {
                Text(
                    text = vital.dateTimeText,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

        }
    }
}



