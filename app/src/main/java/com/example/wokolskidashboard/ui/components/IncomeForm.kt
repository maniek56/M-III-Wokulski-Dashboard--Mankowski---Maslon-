package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.wokolskidashboard.model.Transaction

@Composable
fun IncomeForm(onAddTransaction: (Transaction) -> Unit ) {
    var name by remember{mutableStateOf("")}

    var amount by remember{mutableStateOf("")}

}