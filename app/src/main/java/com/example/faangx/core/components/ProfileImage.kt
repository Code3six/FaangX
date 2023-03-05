package com.example.faangx.core.components

import android.Manifest
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.huhx.picker.constant.AssetPickerConfig
import com.huhx.picker.data.AssetInfo
import com.huhx.picker.data.PickerPermission
import com.huhx.picker.data.PickerPermissions
import com.huhx.picker.view.AssetPicker

@Composable
fun ProfileImage(photoUrl: String){
    AsyncImage(
        modifier = Modifier
            .clip(CircleShape)
            .size(100.dp)
            .clickable {

            },
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photoUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}

