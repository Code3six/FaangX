package com.example.faangx.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.ui.theme.bgColor2
import com.example.faangx.presentation.ui.theme.century1
import com.example.faangx.presentation.ui.theme.purpleTransparent

@Composable
fun AddImage(){
    Column(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.purpleTransparent)
            .padding(6.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.add_photo),
            contentDescription = null,
            tint = MaterialTheme.colors.bgColor2
        )
        Text(
            text = "Add Image",
            style = MaterialTheme.typography.century1,
            color = MaterialTheme.colors.bgColor2,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun AddImagePreview(){
    FaangxTheme {
        AddImage()
    }
}