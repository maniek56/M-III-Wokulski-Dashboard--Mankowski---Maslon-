package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val transactions = remember { mutableStateListOf<Transaction>()}

    var balance = 0.0
    for(t in transactions)
    {
        if(t.isExpense) {
            balance -= t.amount
        } else {
            balance += t.amount
        }
    }

    Column(modifier = modifier) {
        BalanceHeader(balance = balance)

        IncomeForm (onAddTransaction = { transaction -> transactions.add(transaction)
        })
        ExpenseForm (onAddTransaction = { transaction ->
            transactions.add(transaction)
        })

        Text(
            text = "Historia:",
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(transactions) { t ->

                Text(
                    text = "${t.title}: ${t.amount} rub. [${t.category}]",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}