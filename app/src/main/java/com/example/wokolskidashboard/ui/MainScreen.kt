package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.components.TransactionCard

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
    if(balance < 0){
        balance = 0.0
    }

        Column(modifier = modifier.fillMaxSize()) {
            BalanceHeader(balance = balance)

            IncomeForm (onAddTransaction = { transaction -> transactions.add(transaction)
            })
            Spacer(modifier =  Modifier.height(16.dp))
            ExpenseForm (
                currentBalance = balance,
                onAddTransaction = { transaction ->
                transactions.add(transaction)
            })
            Spacer(modifier =  Modifier.height(16.dp))
        Column(
                modifier =  Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
            Text(
                text = "Historia:",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
                )
        LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){
        items(transactions.reversed()) { t ->
                    TransactionCard(t)
                }
            }
        }
    }
}