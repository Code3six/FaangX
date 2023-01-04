package com.example.faangx.presentation.ui.screens.editprofile

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.faangx.R
import com.example.faangx.core.components.AddImage
import com.example.faangx.core.components.ProfileImage
import com.example.faangx.core.components.RadioGroup
import com.example.faangx.domain.model.Gender
import com.example.faangx.domain.repository.LoginDatastoreRepository
import com.example.faangx.presentation.ui.theme.*
import com.example.faangx.presentation.viewmodel.SharedViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditProfileContent(
    navigateToProfileScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){
    var isError = rememberSaveable{ mutableStateOf(false)}.value
    val context = LocalContext.current
    val datastore = LoginDatastoreRepository(context)
    val genderList = listOf(Gender.MALE.name, Gender.FEMALE.name)

    var birthday by remember { mutableStateOf(sharedViewModel.user.value.birthday)}
    var bio by remember {
        mutableStateOf(sharedViewModel.user.value.bio)
    }

    var name by remember{ mutableStateOf(sharedViewModel.user.value.name)}
    var email by remember{mutableStateOf(sharedViewModel.user.value.email)}
    var phone by remember{mutableStateOf(sharedViewModel.user.value.phoneNumber)}
    if(phone == "No Data") phone = ""
    var photoUrl by remember{ mutableStateOf(sharedViewModel.user.value.photoUrl)}

    Log.d("EditProfileContent",name)

    Log.d("name", sharedViewModel.user.collectAsState().value.name)
    Log.d("email", sharedViewModel.user.collectAsState().value.email)
    Log.d("phone", sharedViewModel.user.collectAsState().value.phoneNumber)
    Log.d("photourl", sharedViewModel.user.collectAsState().value.photoUrl)

    var (gender, setGender) = remember { mutableStateOf(sharedViewModel.user.value.gender) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(SIDE_PADDING, CONTENT_TOP_PADDING),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditProfileImage(photoUrl = photoUrl)
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                name = it
            },
            placeholder = {
                Text(
                    text = "Name"
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
            trailingIcon = {
               if(isError && name.isEmpty()){
                   Text(
                       text = "*",
                       color = MaterialTheme.colors.redStar
                   )
               }
            },
            singleLine = true
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = {
                Text(
                    text = "Email"
                )
            },
            textStyle = MaterialTheme.typography.montserrat16,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
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
            trailingIcon = {
                if(isError && email.isEmpty()){
                    Text(
                        text = "*",
                        color = MaterialTheme.colors.redStar
                    )
                }
            },
            singleLine = true
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = phone,
            onValueChange = {
                phone = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text(
                    text = "Phone"
                )
            },
            keyboardActions = KeyboardActions(
                onNext = { ImeAction.Next }
            ),
            trailingIcon = {
                if(isError && phone.isEmpty()){
                    Text(
                        text = "*",
                        color = MaterialTheme.colors.redStar
                    )
                }
            },
            textStyle = MaterialTheme.typography.montserrat16,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    tint = MaterialTheme.colors.bgColor2
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = birthday,
            onValueChange = {
                birthday= it
            },
            placeholder = {
                Text(
                    text = "Birthday DD/MM/YYY"
                )
            },
            keyboardActions = KeyboardActions(
                onNext = { ImeAction.Next }
            ),
            trailingIcon = {
                if(isError && phone.isEmpty()){
                    Text(
                        text = "*",
                        color = MaterialTheme.colors.redStar
                    )
                }
            },
            textStyle = MaterialTheme.typography.montserrat16,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = MaterialTheme.colors.bgColor2
                )
            },
            singleLine = true
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = bio,
            onValueChange = {
                bio = it
            },
            keyboardActions = KeyboardActions(
                onNext = { ImeAction.Next }
            ),
            placeholder = {
                Text(
                    text = "Bio"
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
            trailingIcon = {
                if(isError && bio.isEmpty()){
                    Text(
                        text = "*",
                        color = MaterialTheme.colors.redStar
                    )
                }
            },
            singleLine = false
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
            RadioGroup(items = genderList, selected = gender, setSelected = setGender)
        }

        Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = {
                if(sharedViewModel.checkEditProfileInfo(
                    name = name,
                    email = email,
                    photoUrl = photoUrl,
                    gender = gender,
                    birthday = birthday,
                    bio = bio,
                    phone = phone
                )){
                    sharedViewModel.saveEditProfile(
                        name = name,
                        email = email,
                        photoUrl = photoUrl,
                        gender = gender,
                        birthday = birthday,
                        bio = bio,
                        phone = phone,
                        datastore = datastore
                    )

                    navigateToProfileScreen()
                } else {
                    isError = true
                }
            },
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
fun EditProfileImage(photoUrl: String) {
    if (photoUrl.isEmpty()) {
       AddImage()
    }
    else{
        ProfileImage(photoUrl = photoUrl)
    }
}