package com.example.faangx.presentation.ui.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.viewmodel.SharedViewModel

@Composable
fun ProfileScreen(
    navigateToEditProfileScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    Scaffold(
        topBar = { ProfileTopBar(
            sharedViewModel = sharedViewModel,
            navigateToEditProfileScreen = navigateToEditProfileScreen
        ) },
        content = { ProfileContent(
            sharedViewModel = sharedViewModel
        ) }
    )
}


@Preview
@Composable
fun ProfileScreenPreview(){
    FaangxTheme {
    }
}