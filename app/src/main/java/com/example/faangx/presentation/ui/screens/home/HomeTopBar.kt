package com.example.faangx.presentation.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.*

@Composable
fun HomeTopBar(navigateToProfileScreen: () -> Unit){
    Row(
        modifier = Modifier
            .height(APP_BAR_SIZE)
            .fillMaxWidth()
            .background(MaterialTheme.colors.appTheme)
            .padding(SIDE_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "ChatApp",
            style = MaterialTheme.typography.header,
            color = Color.White
        )
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile Icon",
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun HomeTopBarPreview(){
    FaangxTheme {
        HomeTopBar({})
    }
}