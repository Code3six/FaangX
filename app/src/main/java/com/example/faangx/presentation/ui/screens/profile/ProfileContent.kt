package com.example.faangx.presentation.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.faangx.presentation.ui.theme.CONTENT_TOP_PADDING
import com.example.faangx.presentation.ui.theme.SIDE_PADDING
import com.example.faangx.presentation.viewmodel.SharedViewModel

@Composable
fun ProfileContent(
    sharedViewModel: SharedViewModel
){
    val user = object {
        val email by sharedViewModel.email.collectAsState()
        val bio by sharedViewModel.bio.collectAsState()
        val phone by sharedViewModel.phone.collectAsState()
        val birthday by sharedViewModel.birthday.collectAsState()
        val photoUrl by sharedViewModel.photoUrl.collectAsState()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(SIDE_PADDING, CONTENT_TOP_PADDING),
        verticalArrangement = Arrangement.spacedBy(SIDE_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage(photoUrl = user.photoUrl)
        Text(
            text = user.bio
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
                text = user.email,
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
                imageVector = Icons.Filled.Phone,
                contentDescription = null
            )
            Text(
                text = user.phone,
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
                text = user.birthday.toFormatDate(),
                fontSize = 16.sp
            )
        }
    }
}

fun String.toFormatDate(): String{
    val regex =" /[0-9]+/".toRegex()
    return this.replace(regex, findMonthString(regex.toString()))


}

fun findMonthString(subString: String):String{
    return when(subString.replace("/", "")) {
        "01" -> "Jan"
        "02" -> "Feb"
        "03" -> "Mar"
        "04" -> "Apr"
        "05" -> "May"
        "06" -> "Jun"
        "07" -> "Jul"
        "08" -> "Aug"
        "09" -> "Sep"
        "10" -> "Oct"
        "11" -> "Nov"
        else -> "Dec"
    }
}

@Composable
fun ProfileImage(photoUrl: String){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photoUrl)
            .crossfade(true)
            .build(),
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        contentDescription = null
    )
}