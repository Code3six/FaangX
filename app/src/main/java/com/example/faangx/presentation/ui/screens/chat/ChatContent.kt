package com.example.faangx.presentation.ui.screens.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.core.components.UserMessage
import com.example.faangx.R
import com.example.faangx.core.components.GroupMessage
import com.example.faangx.presentation.ui.theme.*

@Composable
fun ChatContent(){

    val users = listOf(true, false, true, false, false)

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.bgColor)
            .fillMaxSize()
            .padding(SIDE_PADDING, CONTENT_TOP_PADDING)
    ){
        Text(
            text = "1 Nov 2022",
            style = MaterialTheme.typography.montserrat16,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            modifier = Modifier
                .weight(9f),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(users.size) { i ->
                GroupMessage(users[i])
            }
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_image_24),
                tint = MaterialTheme.colors.appTheme,
                contentDescription = "",
                modifier = Modifier.weight(2f)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.weight(8f),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = null,
                        tint = MaterialTheme.colors.appTheme
                    )
                },
                placeholder = {
                    Text(
                        text = "Messsage",
                        color = MaterialTheme.colors.homeChatColor,
                        style = MaterialTheme.typography.montserrat16
                    )
                }
            )
        }
    }
}

@Composable
@Preview
fun ChatContentPreview(){
    FaangxTheme {
        ChatContent()
    }
}

