package com.example.faangx.presentation.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.presentation.ui.theme.*
import com.example.faangx.R
import com.example.faangx.core.components.NameAndDescription

@Composable
fun HomeContent(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()) {
            items(5){
                HomeChatItem()
                Divider()
            }
        }
    }

}

@Composable
fun HomeChatItem(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(SIDE_PADDING, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Profile Icon",
                modifier = Modifier.size(42.dp)
            )
            NameAndDescription("Hey Dude")
        }
        Column {
            TimeNotification(0)
        }
    }
}



@Composable
fun TimeNotification(notification: Int){
    Column(
        modifier = Modifier
            .height(63.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            modifier = Modifier
                .padding(top = 12.dp),
            text = "10:00 AM",
            style = MaterialTheme.typography.ChatTime,
            color = MaterialTheme.colors.homeTimeColor
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeContentPreview(){
  FaangxTheme {
      HomeContent()
  }
}