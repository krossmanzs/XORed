package com.xored.viewmodel

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainMenuViewModel: ViewModel() {
    var text by mutableStateOf("")
    var key by mutableStateOf("")
    var selectedItemIndex by mutableStateOf(0)
    private var isEncrypted by mutableStateOf(false)

    fun getEncryptStatus(): String {
        return if (isEncrypted) "Ya" else "Tidak"
    }
    fun getEncryptColor(): Color {
        return if (isEncrypted) Color.Green else Color.Red
    }

    fun encrypt(pesan: String, kunci: String): Boolean {
        val temp = pesan + kunci
        text = ""

        temp.forEachIndexed { index, c ->
            text += c.code.xor(kunci[index % kunci.length].code).toChar()
        }

        isEncrypted = true

        return isEncrypted
    }

    fun decrypt(kunci: String): Boolean {
        var temp = ""

        text.forEachIndexed { index, c ->
            temp += c.code.xor(kunci[index % kunci.length].code).toChar()
        }

        if(temp.length > kunci.length && kunci == temp.substring(temp.length - kunci.length)) {
            text = temp.substring(0, temp.length - kunci.length)
            isEncrypted = false
        }

        return !isEncrypted
    }
}