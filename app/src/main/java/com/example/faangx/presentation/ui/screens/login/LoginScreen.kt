package com.example.faangx.presentation.ui.screens.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.viewmodel.SharedViewModel

@Composable
fun LoginScreen(
    navigateToEditProfileScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    Scaffold(
        topBar = { LoginTopBar() },
        content = { LoginContent(
            sharedViewModel = sharedViewModel,
            navigateToEditProfileScreen = navigateToEditProfileScreen
        ) }
    )
}


@Preview
@Composable
fun LoginScreenPreview(){
    FaangxTheme {
    }
}