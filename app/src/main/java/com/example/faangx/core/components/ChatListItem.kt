package com.example.faangx.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.SIDE_PADDING

@Composable
fun ChatListItem(){
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
            NameAndDescription("user1@example.com")
        }
    }
}