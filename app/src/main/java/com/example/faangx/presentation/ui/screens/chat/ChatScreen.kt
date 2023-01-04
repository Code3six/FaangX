package com.example.faangx.presentation.ui.screens.chat

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun ChatScreen(){
    Scaffold(
        topBar = { ChatTopBar() },
        content = {
            ChatContent()
        }
    )
}