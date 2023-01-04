package com.example.faangx.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.presentation.ui.theme.FaangxTheme
import com.example.faangx.presentation.ui.theme.SIDE_PADDING
import com.example.faangx.presentation.ui.theme.text

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

@Composable
fun ChatListItemWithCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(SIDE_PADDING, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
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
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colors.text,
                checkmarkColor = Color.White,
                uncheckedColor = MaterialTheme.colors.text
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListItemPreview(){
    FaangxTheme {
        ChatListItemWithCheckBox(checked = true, onCheckedChange = {})
    }
}