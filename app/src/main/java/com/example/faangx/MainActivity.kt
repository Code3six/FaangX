package com.example.faangx

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.faangx.core.navigation.NavGraph
import com.example.faangx.presentation.ui.theme.FaangxTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FaangxTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

