package com.example.faangx.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.faangx.presentation.ui.screens.editprofile.EditProfileScreen
import com.example.faangx.presentation.ui.screens.imagePicker.ImagePicker
import com.example.faangx.presentation.ui.screens.login.LoginScreen
import com.example.faangx.presentation.ui.screens.profile.ProfileScreen
import com.example.faangx.presentation.ui.screens.splash.SplashScreen
import com.example.faangx.presentation.viewmodel.SharedViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel = SharedViewModel()
){
    NavHost(navController = navController, startDestination = "splash"){
        composable(
            route = "splash"
        ){
            SplashScreen(navigateToScreen = { screen ->
                navController.navigate(screen)
            }, sharedViewModel = sharedViewModel)
        }

        composable(
            route = "login"
        ){
            LoginScreen(navigateToEditProfileScreen = {
                navController.navigate("editprofile")
            }, sharedViewModel = sharedViewModel)
        }

        composable(
            route = "editprofile"
        ){
            EditProfileScreen(navigateToProfileScreen = {
                navController.navigate("profile")
            }, sharedViewModel = sharedViewModel)
        }

        composable(
            route = "profile"
        ){
            ProfileScreen(navigateToEditProfileScreen = {
                navController.navigate("editprofile")
            }, sharedViewModel = sharedViewModel)
        }

        composable(
            route = "imagepicker"
        ){
            ImagePicker(
                onPicked = { asset ->

                },
                onClose = { asset ->
                    navController.navigateUp()
                }
            )
        }
    }
}