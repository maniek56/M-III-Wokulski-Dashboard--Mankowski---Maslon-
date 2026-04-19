package com.example.wokolskidashboard.ui.components

import android.R.attr.onClick
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun IncomeForm(onAddTransaction: (Transaction) -> Unit ) {
    var name by remember{mutableStateOf("")}

    var amount by remember{mutableStateOf("")}

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Dodaj przychód: ")

        val isNameValid = name.any {it.isDigit()}
        val isAmountValid = amount.isNotEmpty() && amount.toDoubleOrNull() == null

        WokulskiTextField(value = name, onValueChange = { name = it }, label="Nazwa towaru")
        if(isNameValid)
        {
            Text(text="Nazwa nie może zawierać liczb!", color = Color.Red)
        }

        WokulskiTextField(value = amount, onValueChange = { amount = it }, label="Kwota")
        if(isAmountValid)
        {
            Text(text="Kwota nie zawierać liter!", color = Color.Red)
        }
        WokulskiButton (text = "Zapisz",
            enabled = !isNameValid && !isAmountValid,
            onClick =  {
            val finalAmount = amount.toDouble()
            val newTransaction = Transaction(name, finalAmount, false)

            onAddTransaction(newTransaction)
            name = ""
            amount = ""
        })
    }
}
