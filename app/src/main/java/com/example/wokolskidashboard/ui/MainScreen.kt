package com.example.wokolskidashboard.ui
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.wokolskidashboard.model.Transaction

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val transactions = remember { mutableStateListOf<Transaction>()}

    var balance = 0.0
    for(t in transactions)
    {
        if(t.isExpense) {
            balance = balance - t.amount
        } else {
            balance = balance + t.amount
        }
    }
}
