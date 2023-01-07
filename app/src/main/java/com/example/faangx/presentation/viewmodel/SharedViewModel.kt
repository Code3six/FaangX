package com.example.faangx.presentation.viewmodel

import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faangx.domain.model.User
import com.example.faangx.domain.repository.LoginDatastoreRepository
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class SharedViewModel: ViewModel() {

    private var _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user.asStateFlow()

    private val db = Firebase.firestore

    private var signInIntent: Intent = Intent()
    val firebaseAuthUiContract = FirebaseAuthUIActivityResultContract()

    private val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())

    private var isLogged = MutableStateFlow(false)


    fun checkEditProfileInfo(
        name: String,
        phone: String,
        email: String,
        photoUrl: String,
        gender: String,
        bio: String,
        birthday: String
    ):Boolean{
        return (
            name.isNotEmpty() &&
            phone.isNotEmpty() &&
            email.isNotEmpty() &&
            photoUrl.isNotEmpty() &&
            gender.isNotEmpty() &&
            bio.isNotEmpty() &&
            birthday.isNotEmpty()
        )
    }

    fun onSignInResult(
        result: FirebaseAuthUIAuthenticationResult,
        navigateToProfile: () -> Unit,
        datastore: LoginDatastoreRepository) {
        viewModelScope.launch{
            if (result.resultCode == ComponentActivity.RESULT_OK) {
                // Successfully signed in
                val userData = FirebaseAuth.getInstance().currentUser

                checkUsers(userData!!)
                delay(5000)
                saveLogin(datastore)
                navigateToProfile()

            } else {
                Log.d("Failed", "no message")
            }
        }
    }

    private fun saveLogin(datastore: LoginDatastoreRepository){
        viewModelScope.launch {
            datastore.saveInfo(
                name = user.value.name,
                email = user.value.email,
                photoUrl = user.value.photoUrl,
                phone = user.value.phoneNumber,
                log = user.value.name.isNotEmpty(),
                gender = user.value.gender,
                bio = user.value.bio,
                birthday = user.value.birthday
            )
        }
    }

    private fun checkUsers(user: FirebaseUser){
        viewModelScope.launch{
            val users = db.collection("users")
            users.get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("checkUsers", "${document.data["email"]!!::class.simpleName}")
                        if (user.email == document.data["email"]) {
                            updateUserDataFs(document)
                        } else updateUserData(user)
                    }
                }.await()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveEditProfile(
        datastore: LoginDatastoreRepository,
        name: String,
        phone: String,
        email: String,
        photoUrl: String,
        gender: String,
        bio: String,
        birthday: String
    ){
        viewModelScope.launch {
            datastore.saveInfo(
                name = name,
                phone = phone,
                email = email,
                photoUrl = photoUrl,
                log = true,
                gender = gender,
                bio = bio,
                birthday = birthday
            )
            val user = User(
                name = name,
                phoneNumber = phone,
                email = email,
                gender = gender,
                bio = bio,
                birthday = birthday
            )
            db.collection("users")
                .add(user).await()
        }
    }

    fun getLogin(datastore: LoginDatastoreRepository){
        setAll(datastore)
    }

    fun checkLoggerBool():Boolean{
        return isLogged.value
    }

    private fun setAll(datastore: LoginDatastoreRepository) {
        viewModelScope.launch {
            datastore.getEmail.collect {
                _user.value.email = it
            }
        }
        viewModelScope.launch {
            datastore.getLog.collect {
                isLogged.value = it
            }
        }
        viewModelScope.launch {
            datastore.getPhoto.collect {
                _user.value.photoUrl = it
            }
        }
        viewModelScope.launch {
            datastore.getName.collect {
                _user.value.name = it
            }
        }
        viewModelScope.launch {
            datastore.getPhone.collect {
                _user.value.phoneNumber = it
            }
        }
        viewModelScope.launch {
            datastore.getGender.collect {
                _user.value.gender = it
            }
        }
        viewModelScope.launch {
            datastore.getBio.collect {
                _user.value.bio = it
            }
        }
        viewModelScope.launch {
            datastore.getBirthday.collect {
                _user.value.birthday = it
            }
        }
    }

    fun onSignInAttempt(signInLauncher: ActivityResultLauncher<Intent>){
        signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()

        signInLauncher.launch(signInIntent)
    }
    private fun updateUserDataFs(userD: QueryDocumentSnapshot){
            _user.update {
                it.copy(
                    photoUrl = userD.data["photoUrl"] as String,
                    name = userD.data["name"] as String,
                    email = userD.data["email"] as String,
                    phoneNumber = userD.data["phoneNumber"] as String,
                    bio = userD.data["bio"] as String,
                    birthday = userD.data["birthday"] as String,
                    gender = userD.data["gender"] as String
                )
            }
        Log.d("updateUserDataFS", user.value.name)
    }
    private fun updateUserData(
        userData: FirebaseUser
    ){
        _user.update {
            it.copy(
                photoUrl = userData.photoUrl?.toString() ?:"",
                name = userData.displayName?:"No Data",
                email = userData.email?:"No Data",
                phoneNumber = userData.phoneNumber?:"",
                bio = "",
                birthday = "",
                gender = ""
            )
        }
        Log.d("updateUserData", _user.value.name)
    }

}