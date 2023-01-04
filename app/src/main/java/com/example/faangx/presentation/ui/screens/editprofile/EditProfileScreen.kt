package com.example.faangx.presentation.ui.screens.editprofile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.viewmodel.SharedViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditProfileScreen(
    navigateToProfileScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    Scaffold(
        topBar = { EditProfileTopBar() },
        content = {
            EditProfileContent(
                navigateToProfileScreen = navigateToProfileScreen,
                sharedViewModel = sharedViewModel
            )
        }
    )
}


@Preview
@Composable
fun EditProfileScreenPreview(){
    FaangxTheme {

    }
}