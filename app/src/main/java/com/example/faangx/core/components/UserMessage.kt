package com.example.faangx.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.presentation.ui.theme.*

//user = true means user of the app, false means other user

@Composable
fun UserMessage(user: Boolean){

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = if(user)Arrangement.Start else Arrangement.End
    ){
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .widthIn(0.dp, 270.dp)
                .background(MaterialTheme.colors.chatBox)
                .padding(10.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "Hey",
                style = MaterialTheme.typography.montserrat16,
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "8:00AM",
                style = MaterialTheme.typography.TextTime,
                color = MaterialTheme.colors.homeChatColor
            )
        }
    }
}

@Composable
fun GroupMessage(user: Boolean){
    if(user) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .widthIn(0.dp, 270.dp)
                    .background(MaterialTheme.colors.chatBox)
                    .padding(10.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Hey",
                    style = MaterialTheme.typography.montserrat16,
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "8:00AM",
                    style = MaterialTheme.typography.TextTime,
                    color = MaterialTheme.colors.homeChatColor
                )
            }
        }
    }
    else {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "user324",
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .widthIn(0.dp, 270.dp)
                        .background(MaterialTheme.colors.chatBox)
                        .padding(10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Hey",
                        style = MaterialTheme.typography.montserrat16,
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "8:00AM",
                        style = MaterialTheme.typography.TextTime,
                        color = MaterialTheme.colors.homeChatColor
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun UserMessagePreview(){
    FaangxTheme {
        GroupMessage(false)
    }
}