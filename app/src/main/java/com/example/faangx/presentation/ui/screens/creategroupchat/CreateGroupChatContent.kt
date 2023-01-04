package com.example.faangx.presentation.ui.screens.creategroupchat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.faangx.core.components.AddImage
import com.example.faangx.core.components.ChatListItem
import com.example.faangx.presentation.ui.theme.*

@Composable
fun CreateGroupChatContent(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SIDE_PADDING, CONTENT_TOP_PADDING),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AddImage()
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = "Group Name"
                    )
                },
                textStyle = MaterialTheme.typography.montserrat16,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colors.bgColor2
                    )
                },
                keyboardActions = KeyboardActions(
                    onNext = { ImeAction.Next }
                ),
                trailingIcon = {},
                singleLine = true
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        text = "Group Description"
                    )
                },
                textStyle = MaterialTheme.typography.montserrat16,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colors.bgColor2
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                keyboardActions = KeyboardActions(
                    onNext = { ImeAction.Next }
                ),
                trailingIcon = {},
                singleLine = true
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


@Preview
@Composable
fun CreateGroupChatContentPreview(){
    FaangxTheme {
        CreateGroupChatContent()
    }
}