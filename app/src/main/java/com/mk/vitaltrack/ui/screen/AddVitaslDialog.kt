package com.mk.vitaltrack.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.mk.vitaltrack.domain.model.VitalsInputModel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (VitalsInputModel) -> Unit
) {
    var input by remember { mutableStateOf(VitalsInputModel()) }

    val isValid = input.systolicBp.isNotBlank() &&
            input.diastolicBp.isNotBlank() &&
            input.heartRate.isNotBlank() &&
            input.weight.isNotBlank() &&
            input.babyKicks.isNotBlank()


    Dialog(onDismissRequest = onDismiss) {
        Card(shape = RoundedCornerShape(16.dp)) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {

                Text(
                    "Add Vitals",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primaryContainer
                )

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = input.systolicBp,
                        onValueChange = { newVal ->
                            if (newVal.all { it.isDigit() }) input = input.copy(systolicBp = newVal)
                        },
                        isError = input.systolicBp.isBlank(),
                        label = { Text("Sys BP") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.weight(1f),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            unfocusedLabelColor = Color.DarkGray
                        )
                    )

                    OutlinedTextField(
                        value = input.diastolicBp,
                        onValueChange = { newVal ->
                            if (newVal.all { it.isDigit() }) input =
                                input.copy(diastolicBp = newVal)
                        },
                        isError = input.diastolicBp.isBlank(),
                        label = { Text("Dia BP") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.weight(1f),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            unfocusedLabelColor = Color.DarkGray
                        )
                    )
                }

                OutlinedTextField(
                    value = input.heartRate,
                    onValueChange = { newVal ->
                        if (newVal.all { it.isDigit() }) input = input.copy(heartRate = newVal)
                    },
                    isError = input.heartRate.isBlank(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    label = { Text("Heart Rate") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        unfocusedLabelColor = Color.DarkGray
                    ),
                )

                OutlinedTextField(
                    value = input.weight,
                    onValueChange = { newVal ->
                        if (newVal.all { it.isDigit() }) input = input.copy(weight = newVal)
                    },
                    isError = input.weight.isBlank(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    label = { Text("Weight (kg)") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        unfocusedLabelColor = Color.DarkGray
                    )
                )

                OutlinedTextField(
                    value = input.babyKicks,
                    onValueChange = { newVal ->
                        if (newVal.all { it.isDigit() }) input = input.copy(babyKicks = newVal)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    isError = input.babyKicks.isBlank(),
                    label = { Text("Baby Kicks") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        unfocusedLabelColor = Color.DarkGray
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { onSubmit(input) },
                        modifier = Modifier.align(Alignment.Center), // centers in Box
                        shape = RoundedCornerShape(4.dp),
                        enabled = isValid,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        )
                    ) {
                        Text("Submit", color = Color.White)
                    }
                }

            }
        }
    }
}
