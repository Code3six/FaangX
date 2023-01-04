package com.example.faangx.presentation.ui.screens.creategroupchat

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme

@Composable
fun CreateGroupChatScreen(){
    Scaffold(
        topBar = { CreateGroupChatTopBar() },
        content = {
            CreateGroupChatContent()
        }
    )
}

@Preview
@Composable
fun CreateGroupChatScreenPreview(){
    FaangxTheme {
        CreateGroupChatScreen()
    }
}