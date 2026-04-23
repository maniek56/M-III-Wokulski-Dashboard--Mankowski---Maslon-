package com.example.wokolskidashboard.ui.components

import android.R.attr.onClick
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun IncomeForm(onAddTransaction: (Transaction) -> Unit ) {
    var name by remember{mutableStateOf("")}

    var amount by remember{mutableStateOf("")}

    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
        Text(
            text = "Dodaj przychód: ",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        val isNameValid = name.any { it.isDigit() }
        val isAmountValid = amount.isNotEmpty() && amount.toDoubleOrNull() == null

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            WokulskiTextField(value = name, onValueChange = { name = it }, label = "Nazwa towaru")
            if (isNameValid) {
                Text(
                    text = "Nazwa nie może zawierać liczb!",
                    color = Color.Red,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            WokulskiTextField(value = amount, onValueChange = { amount = it }, label = "Kwota")
            if (isAmountValid) {
                Text(
                    text = "Kwota nie zawierać liter!",
                    color = Color.Red,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier =  Modifier.height(24.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            WokulskiButton(
                text = "Zapisz w księdze",
                enabled = !isNameValid && !isAmountValid,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val finalAmount = amount.toDouble()
                    val newTransaction = Transaction(name, finalAmount, false)

                    onAddTransaction(newTransaction)
                    name = ""
                    amount = ""
                })
            }
        }
    }
