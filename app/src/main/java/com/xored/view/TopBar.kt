package com.xored.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xored.model.NavigationItem
import com.xored.viewmodel.MainMenuViewModel

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
fun DrawerSheet(
    viewModel: MainMenuViewModel,
    onDrawerItemClick: () -> Unit
) {
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
                Text(text = "Nama: Cornelius Linux")
                Text(text = "NIM: 122140079")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        
    }
}