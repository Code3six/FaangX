package com.example.faangx.presentation.ui.screens.login
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.faangx.R
import com.example.faangx.domain.repository.LoginDatastoreRepository
import com.example.faangx.presentation.ui.theme.SIDE_PADDING
import com.example.faangx.presentation.ui.theme.loginBG
import com.example.faangx.presentation.ui.theme.text
import com.example.faangx.presentation.viewmodel.SharedViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginContent(
    navigateToEditProfileScreen: () -> Unit,
    sharedViewModel: SharedViewModel
){

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val datastoreRepository = LoginDatastoreRepository(context = context)

    val signInLauncher = rememberLauncherForActivityResult(
        contract = sharedViewModel.firebaseAuthUiContract,
        onResult = { res -> sharedViewModel.onSignInResult(
            res,
            navigateToEditProfileScreen,
            datastoreRepository
        ) }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.loginBG),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                    sharedViewModel.onSignInAttempt(signInLauncher)

            },
            modifier = Modifier
                .padding(SIDE_PADDING),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            shape = RectangleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Sign in with Google",
                color = MaterialTheme.colors.text
            )
        }
    }
}

