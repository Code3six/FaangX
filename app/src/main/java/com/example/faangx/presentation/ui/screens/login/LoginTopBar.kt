package com.example.faangx.presentation.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.*

@Composable
fun LoginTopBar(){
    Row(
      modifier = Modifier
          .height(APP_BAR_SIZE)
          .fillMaxWidth()
          .background(MaterialTheme.colors.appTheme)
          .padding(SIDE_PADDING),
    verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(id = R.string.welcome),
            style = MaterialTheme.typography.header,
            color = Color.White
        )
    }
}

@Composable
@Preview
fun LoginTopBarPreview(){
    FaangxTheme {
        LoginTopBar()
    }
}