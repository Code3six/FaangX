package com.example.faangx.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.ui.theme.appTheme

@Composable
fun HomeScreen(
    navigateToProfileScreen: () -> Unit
){
    Scaffold(
        topBar = { HomeTopBar(navigateToProfileScreen) },
        content = {
            HomeContent()
        },
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ){
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    backgroundColor = MaterialTheme.colors.appTheme
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_people_24),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    backgroundColor = MaterialTheme.colors.appTheme
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    FaangxTheme {
        HomeScreen({})
    }
}