package com.example.faangx.presentation.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.faangx.presentation.ui.theme.APP_BAR_SIZE
import com.example.faangx.presentation.ui.theme.SIDE_PADDING
import com.example.faangx.presentation.ui.theme.appTheme
import com.example.faangx.presentation.ui.theme.header

@Composable
fun ProfileTopBar(){
    Row(
        modifier = Modifier
            .height(APP_BAR_SIZE)
            .fillMaxWidth()
            .background(MaterialTheme.colors.appTheme)
            .padding(SIDE_PADDING),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Lorem Ipsum",
            style = MaterialTheme.typography.header,
            color = Color.White
        )
    }
}