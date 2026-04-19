package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WokulskiTextField(value: String, onValueChange: (String) -> Unit, label: String)
{
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {Text(label)}
    )
}

@Composable
fun WokulskiButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = enabled,
        ) {
        Text(text)
    }
}
