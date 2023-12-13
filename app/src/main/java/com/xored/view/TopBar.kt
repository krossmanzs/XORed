package com.xored.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xored.model.NavigationItem
import com.xored.viewmodel.MainMenuViewModel
import kotlinx.coroutines.launch

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
    val items = listOf(
        NavigationItem(
            title = "All",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        NavigationItem(
            title = "Urgent",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info
        ),
        NavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        )
    )

    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(16.dp))
        items.forEachIndexed{ index, item ->
            NavigationDrawerItem(
                label = { Text(text = item.title) },
                selected = index == viewModel.selectedItemIndex,
                onClick = onDrawerItemClick.also {
                    viewModel.selectedItemIndex = index
                },
                icon = {
                    Icon(
                        imageVector = if(index == viewModel.selectedItemIndex) item.selectedIcon
                        else item.unselectedIcon,
                        contentDescription = item.title)
                },
                modifier = Modifier
                    .padding(NavigationDrawerItemDefaults.ItemPadding))
        }
    }
}