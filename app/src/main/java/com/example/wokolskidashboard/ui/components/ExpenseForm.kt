package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun ExpenseForm(onAddTransaction: (Transaction) -> Unit) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Sklep") }
    var isLuxury by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        Text(
            text = "Dodaj wydatek: ",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        val isNameValid = name.any { it.isDigit() }
        val isAmountValid = amount.isNotEmpty() && amount.toDoubleOrNull() == null
        val isFormReady = name.isNotBlank() && amount.isNotBlank()

        Spacer(modifier = Modifier.height(16.dp))

        WokulskiTextField(value = name, onValueChange = { name = it }, label = "Cel wydatku")
        if (isNameValid) {
            Text("Nazwa nie może zawierać liczb!", color = Color.Red, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        WokulskiTextField(value = amount, onValueChange = { amount = it }, label = "Kwota (ruble)")
        if (isAmountValid) {
            Text("Kwota musi być liczbą!", color = Color.Red, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = isLuxury, onCheckedChange = { isLuxury = it })
            Text("Wydatek zbyteczny (luksusowy)")
        }
        Text("Wybierz kategorię: $selectedCategory")

        Row {
            Button(onClick = { selectedCategory = "Sklep" }) { Text("Sklep") }
            Button(onClick = { selectedCategory = "Izabela" }) { Text("Izabela") }
        }
        Row {
            Button(onClick = { selectedCategory = "Kamienice" }) { Text("Kamienice") }
            Button(onClick = { selectedCategory = "Osobiste" }) { Text("Osobiste") }
        }
        Spacer(modifier = Modifier.height(16.dp))

        WokulskiButton(
            text = "Zapisz koszt",
            enabled = !isNameValid && !isAmountValid && isFormReady,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val finalAmount = amount.toDoubleOrNull() ?: 0.0

                val newTransaction = Transaction(title = name, amount = finalAmount, isExpense = true, isLuxury = isLuxury, category=selectedCategory)

                onAddTransaction(newTransaction)
                name = ""
                amount = ""
                isLuxury = false

            }
        )
    }
}
