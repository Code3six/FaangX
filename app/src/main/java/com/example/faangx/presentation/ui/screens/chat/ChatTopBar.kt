package com.example.faangx.presentation.ui.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.APP_BAR_SIZE
import com.example.faangx.presentation.ui.theme.SIDE_PADDING
import com.example.faangx.presentation.ui.theme.appTheme
import com.example.faangx.presentation.ui.theme.header

@Composable
fun ChatTopBar(){
    val name = ""
    Row(
        modifier = Modifier
            .height(APP_BAR_SIZE)
            .fillMaxWidth()
            .background(MaterialTheme.colors.appTheme)
            .padding(SIDE_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(SIDE_PADDING)
    ){
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .clickable {

                }
        )
        Text(
            text = name,
            style = MaterialTheme.typography.header,
            color = Color.White
        )
    }
}