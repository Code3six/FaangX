package com.example.faangx.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.faangx.presentation.ui.theme.ChatName
import com.example.faangx.presentation.ui.theme.ChatText
import com.example.faangx.presentation.ui.theme.text

@Composable
fun NameAndDescription(desc: String){
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .padding(top = 9.dp),
            text = "Saurab Gupta",
            style = MaterialTheme.typography.ChatName,
            color = MaterialTheme.colors.text
        )
        Text(
            modifier = Modifier
                .padding(bottom = 12.dp),
            text = desc,
            style = MaterialTheme.typography.ChatText,
            color = Color.Gray
        )
    }
}