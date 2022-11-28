package com.example.faangx.presentation.ui.screens.profile

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.CONTENT_TOP_PADDING
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.ui.theme.SIDE_PADDING

@Composable
fun ProfileContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(SIDE_PADDING, CONTENT_TOP_PADDING),
        verticalArrangement = Arrangement.spacedBy(SIDE_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage()
        Text(
            text = stringResource(id = R.string.lorem_bio)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(SIDE_PADDING)
        ){
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null
            )
            Text(
                text = "lorem.ipsum@abc.com",
                fontSize = 16.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(SIDE_PADDING)
        ){
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = null
            )
            Text(
                text = "30 Feb 2002",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ProfileImage(){
    Image(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.image) ,
        contentDescription = null
    )
}

@Composable
@Preview
fun ProfileContentPreview(){
    FaangxTheme {
        ProfileContent()
    }
}