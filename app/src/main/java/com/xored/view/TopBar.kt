package com.xored.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onNavicationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "XORed")
        },
        navigationIcon = {
            IconButton(onClick = onNavicationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerSheet() {
    ModalDrawerSheet {
        Box(modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "TUGAS BESAR MATEMATIKA DISKRIT",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
                Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.padding(bottom = 8.dp, top = 8.dp))
                Text(text = "Aplikasi End-To-End Encryption pada Pengiriman Pesan Menggunakan Algoritma XOR Cipher Sederhana",
                    fontWeight = FontWeight.Bold)
                Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.padding(bottom = 8.dp, top = 8.dp))
                Text(text = "Nama: Cornelius Linux")
                Text(text = "NIM: 122140079")


            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        
    }
}