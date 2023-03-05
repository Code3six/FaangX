package com.example.faangx.presentation.ui.screens.editprofile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.faangx.core.components.AddImage
import com.example.faangx.core.components.ProfileImage
import com.example.faangx.core.components.RadioGroup
import com.example.faangx.domain.model.Gender
import com.example.faangx.domain.model.User
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



    var user: User = User(
        name = sharedViewModel.user.collectAsState().value.name,
        email = sharedViewModel.user.collectAsState().value.email,
        phoneNumber = sharedViewModel.user.collectAsState().value.phoneNumber,
        photoUrl = sharedViewModel.user.collectAsState().value.photoUrl,
        gender = sharedViewModel.user.collectAsState().value.gender,
        bio = sharedViewModel.user.collectAsState().value.bio,
        birthday = sharedViewModel.user.collectAsState().value.birthday
    )

    var name: MutableState<String> = remember {
        mutableStateOf(user.name)
    }
    var email: MutableState<String> = remember {
        mutableStateOf(user.email)
    }
    var phoneNumber: MutableState<String> = remember {
        mutableStateOf(user.phoneNumber)
    }
    var photoUrl: MutableState<String> = remember {
        mutableStateOf(user.photoUrl)
    }
    var bio: MutableState<String> = remember {
        mutableStateOf(user.bio)
    }
    var birthday: MutableState<String> = remember {
        mutableStateOf(user.birthday)
    }


    var (gender, setGender) = remember { mutableStateOf(sharedViewModel.user.value.gender) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.bgColor)
            .verticalScroll(
                rememberScrollState(),
                true,
                null
            )
            .padding(SIDE_PADDING, CONTENT_TOP_PADDING),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditProfileImage(photoUrl = photoUrl.value)
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name.value,
            onValueChange = {
                name.value = it
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
               if(isError && name.value.isEmpty()){
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
            value = email.value,
            onValueChange = {
                email.value = it
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
                if(isError && email.value.isEmpty()){
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
            value = phoneNumber.value,
            onValueChange = {
                phoneNumber.value = it
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
                if(isError && phoneNumber.value.isEmpty()){
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
            value = birthday.value ,
            onValueChange = {
                birthday.value = it
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
                if(isError && birthday.value.isEmpty()){
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
            value = bio.value,
            onValueChange = {
                bio.value = it
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
                if(isError && bio.value.isEmpty()){
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
                    userInfo = User(
                        name = name.value,
                        email = email.value,
                        photoUrl = photoUrl.value,
                        phoneNumber = phoneNumber.value,
                        bio = bio.value,
                        birthday = birthday.value,
                        gender = gender
                    )
                )){
                    sharedViewModel.saveEditProfile(
                        userInfo = User(
                            name = name.value,
                            email = email.value,
                            photoUrl = photoUrl.value,
                            phoneNumber = phoneNumber.value,
                            bio = bio.value,
                            birthday = birthday.value,
                            gender = gender
                        ),
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


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditProfileContentPreview(){
    FaangxTheme {
        EditProfileContent(navigateToProfileScreen = { /*TODO*/ }, sharedViewModel = viewModel())
    }
}