package com.example.faangx.presentation.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.ui.theme.bgColor1
import com.example.faangx.presentation.ui.theme.bgColor2


@Composable
fun SplashScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colors.bgColor1,
                    MaterialTheme.colors.bgColor2
                )
            )),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(
            painter = painterResource(id = R.drawable.chat_filled),
            tint = Color.White,
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SplashScreenPreview(){
    FaangxTheme {
        SplashScreen()
    }
}