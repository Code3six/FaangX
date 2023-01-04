package com.example.faangx.presentation.ui.screens.newchat

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme

@Composable
fun NewChatScreen(){
    Scaffold(
        topBar = { NewChatTopBar() },
        content = {
            NewChatContent()
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewChatScreenPreview(){
    FaangxTheme {
        NewChatContent()
    }
}