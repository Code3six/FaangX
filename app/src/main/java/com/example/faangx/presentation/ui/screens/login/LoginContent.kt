package com.example.faangx.presentation.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.ui.theme.SIDE_PADDING
import com.example.faangx.presentation.ui.theme.loginBG
import com.example.faangx.presentation.ui.theme.text

@Composable
fun LoginContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.loginBG),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(SIDE_PADDING),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            shape = RectangleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Sign in with Google",
                color = MaterialTheme.colors.text
            )
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginContentPreview(){
    FaangxTheme {
        LoginContent()
    }
}