package com.xored.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.xored.viewmodel.MainMenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenu(
    viewModel: MainMenuViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextField(
            value = viewModel.text,
            onValueChange = { newText -> viewModel.text = newText},
            label = { Text(
                text = "Pesan",
                fontSize = 16.sp) }
        )
    }
}