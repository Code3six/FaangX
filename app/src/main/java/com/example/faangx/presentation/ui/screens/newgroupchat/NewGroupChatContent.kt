package com.example.faangx.presentation.ui.screens.newgroupchat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.faangx.R
import com.example.faangx.core.components.ChatListItem
import com.example.faangx.presentation.ui.theme.*

@Composable
fun NewGroupChatContent(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(SIDE_PADDING, CONTENT_TOP_PADDING),
            verticalArrangement = Arrangement.spacedBy(SIDE_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(SIDE_PADDING)
            ) {
                Text(
                    text = "Members",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.montserratBold
                )
            }
        }
        LazyColumn {
            items(3) {
                ChatListItem()
                Divider()
            }
        }
    }
}


@Composable
@Preview
fun NewGroupChatContentPreview(){
    FaangxTheme {
        NewGroupChatContent()
    }
}