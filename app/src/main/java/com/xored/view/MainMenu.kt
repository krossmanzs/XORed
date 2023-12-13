package com.xored.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xored.viewmodel.MainMenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenu(
    viewModel: MainMenuViewModel,
    modifier: Modifier = Modifier,
    context: Context
) {
    val inputPesan = remember { mutableStateOf("") }
    val inputKunci = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        DescriptionCard(viewModel)
        Spacer(modifier = Modifier.height(48.dp))
        OutlinedTextField(
            value = inputPesan.value,
            onValueChange = { newText -> inputPesan.value = newText},
            label = { Text(
                text = "Pesan",
                fontSize = 16.sp)},
            leadingIcon = { Icon(
                imageVector = Icons.Default.MailOutline
                , contentDescription = "Pesan") },
            enabled = viewModel.getEncryptStatus() == "Tidak",
            modifier = Modifier.width(TextFieldDefaults.MinWidth)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = inputKunci.value,
            onValueChange = { newText -> inputKunci.value = newText},
            label = { Text(
                text = "Kunci",
                fontSize = 16.sp) },
            leadingIcon = { Icon(
                imageVector = Icons.Default.Lock
                , contentDescription = "Kunci") },
            modifier = Modifier.width(TextFieldDefaults.MinWidth)
        )
        Spacer(modifier = Modifier.height(24.dp))
        FilledTonalButton(
            modifier = Modifier.width(TextFieldDefaults.MinWidth),
            enabled = viewModel.getEncryptStatus() == "Tidak",
            onClick = {
                if (viewModel.encrypt(inputPesan.value, inputKunci.value)) {
                    Toast.makeText(
                        context,
                        "Berhasil Enkripsi!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Gagal Enkripsi!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
              },
        ) {
            Text(text = "Enkripsi", fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        FilledTonalButton(
            modifier = Modifier.width(TextFieldDefaults.MinWidth),
            enabled = viewModel.getEncryptStatus() == "Ya",
            onClick = {
                if (viewModel.decrypt(inputKunci.value)) {
                    Toast.makeText(
                        context,
                        "Berhasil Dekripsi!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Gagal Dekripsi!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
        ) {
            Text(text = "Dekripsi", fontSize = 24.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionCard(viewModel: MainMenuViewModel) {
    OutlinedCard(
        modifier = Modifier
            .width(TextFieldDefaults.MinWidth),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),

        ) {
        val scrollState = rememberScrollState()
        Column(
            Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Keterangan",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = viewModel.text,
                onValueChange = {},
                textStyle = TextStyle(color = Color.White),
                label = { Text(
                    text = "Pesan",
                    fontSize = 16.sp,
                    color = Color.White) },
                readOnly = true,
                enabled = false,
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .verticalScroll(state = scrollState),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = Color.White
                )
            )
            OutlinedTextField(
                value = viewModel.getEncryptStatus(),
                onValueChange = {},
                textStyle = TextStyle(color = viewModel.getEncryptColor()),
                label = { Text(
                    text = "Terenkripsi",
                    fontSize = 16.sp,
                    color = viewModel.getEncryptColor()) },
                readOnly = true,
                enabled = false,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = viewModel.getEncryptColor()
                )
            )
        }
    }
}