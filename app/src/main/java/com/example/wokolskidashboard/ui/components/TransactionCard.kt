package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun TransactionCard(transaction: Transaction){
    val color = (
            if(transaction.isExpense) {
                Color.Red
            } else {
                Color(0xFF006400)
        })
    val sign = (
            if(transaction.isExpense){
                "-"
            } else {
                "+"
        })

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${transaction.title}: $sign${transaction.amount} rub. [${transaction.category}]",
            modifier = Modifier.padding(2.dp),
            textAlign = TextAlign.Center,
            color = color
        )
    }
}