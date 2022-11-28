package com.example.faangx.presentation.ui.screens.editprofile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme

@Composable
fun EditProfileScreen(){
    Scaffold(
        topBar = { EditProfileTopBar() },
        content = { EditProfileContent() }
    )
}


@Preview
@Composable
fun EditProfileScreenPreview(){
    FaangxTheme {
        EditProfileScreen()
    }
}