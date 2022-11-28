package com.example.faangx.presentation.ui.screens.editprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.core.components.RadioGroup
import com.example.faangx.data.datasource.db.GenderDataSource
import com.example.faangx.presentation.ui.theme.*

@Composable
fun EditProfileContent(){
    val genderList = GenderDataSource.genderList
    var (selected, setSelected) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(SIDE_PADDING, CONTENT_TOP_PADDING),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditProfileImage()
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Name"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colors.bgColor2
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Email"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = MaterialTheme.colors.bgColor2
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Bio"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colors.bgColor2
                )
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.purpleTransparent)
                .padding(SIDE_PADDING)
        ) {
            Text(
                text = "Gender",
                style = MaterialTheme.typography.Gender,
                color = MaterialTheme.colors.text
            )
            RadioGroup(items = genderList, selected = selected, setSelected = setSelected)
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Date of birth"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = MaterialTheme.colors.bgColor2
                )
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.appTheme
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .width(100.dp)
        ) {
            Text(
                text = "SAVE",
                style = MaterialTheme.typography.saveButton,
                color = Color.White
            )
        }
    }
}

@Composable
fun EditProfileImage(){
    Column(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.purpleTransparent)
            .padding(6.dp,0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
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

@Composable
@Preview
fun EditProfileImagePreview(){
    FaangxTheme {
        EditProfileContent()
    }
}