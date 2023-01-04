package com.example.faangx.presentation.ui.screens.newchat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.core.components.ChatListItem
import com.example.faangx.presentation.ui.theme.FaangxTheme

@Composable
fun NewChatContent(){
    LazyColumn(modifier = Modifier
        .fillMaxSize()) {
        items(5){
            ChatListItem()
            Divider()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewChatContentPreview(){
    FaangxTheme {
        NewChatContent()
    }
}