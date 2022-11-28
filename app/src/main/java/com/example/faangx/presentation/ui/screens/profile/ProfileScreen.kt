package com.example.faangx.presentation.ui.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme

@Composable
fun ProfileScreen(){
    Scaffold(
        topBar = { ProfileTopBar() },
        content = { ProfileContent() }
    )
}


@Preview
@Composable
fun ProfileScreenPreview(){
    FaangxTheme {
        ProfileScreen()
    }
}