package com.example.faangx.presentation.ui.screens.newgroupchat

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme

@Composable
fun NewGroupChatScreen(){
    Scaffold(
        topBar = { NewGroupChatTopBar() },
        content = {
            NewGroupChatContent()
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewGroupChatScreenPreview(){
    FaangxTheme {
        NewGroupChatContent()
    }
}