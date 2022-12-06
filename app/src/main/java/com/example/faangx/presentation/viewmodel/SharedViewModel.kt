package com.example.faangx.presentation.viewmodel

import android.content.Intent
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.faangx.domain.model.User
import com.example.faangx.domain.repository.LoginDatastoreRepository
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private var _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user.asStateFlow()

    private var signInIntent: Intent = Intent()
    val firebaseAuthUiContract = FirebaseAuthUIActivityResultContract()

    private val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())

    private var _name = MutableStateFlow("")
    val name = _name
    private var _email = MutableStateFlow("")
    val email = _email
    private var _phone = MutableStateFlow("")
    val phone = _phone
    private var _photoUrl = MutableStateFlow("")
    val photoUrl = _photoUrl

    private var _bio = MutableStateFlow("")
    val bio = _bio
    var gender = mutableStateOf("")
    private var _birthday = MutableStateFlow("")
    val birthday = _birthday

    private var _isLogged = MutableStateFlow(false)
    val isLogged = _isLogged


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
        if (result.resultCode == ComponentActivity.RESULT_OK) {
            // Successfully signed in
            val userData = FirebaseAuth.getInstance().currentUser

            updateUserData(userData)
            saveLogin(datastore)
            navigateToProfile()

        } else {
            Log.d("Failed", "no message")
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
        }
    }

    fun getLogin(datastore: LoginDatastoreRepository){
        setName(datastore)
        Log.d("getLogin", name.value)
        setEmail(datastore)
        setPhone(datastore)
        setPhoto(datastore)
        setLog(datastore)
        setGender(datastore)
        setBio(datastore)
        setBirthday(datastore)
        Log.d("getLogin", "${isLogged.value}")
    }

    fun checkLoggerBool():Boolean{
        return isLogged.value
    }

    private fun setEmail(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getEmail.collect{
                _email.value = it
            }
        }
    }

    private fun setName(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getName.collect{
                _name.value = it
            }
        }
    }

    private fun setLog(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getLog.collect{
                _isLogged.value = it
            }
        }
    }

    private fun setPhone(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getPhone.collect{
                _phone.value = it
            }
        }
    }

    private fun setPhoto(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getPhoto.collect{
                _photoUrl.value = it
            }
        }
    }

    private fun setGender(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getGender.collect{
                gender.value = it
            }
        }
    }

    private fun setBio(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getBio.collect{
                _bio.value = it
            }
        }
    }

    private fun setBirthday(datastore: LoginDatastoreRepository){
        viewModelScope.launch{
            datastore.getBirthday.collect{
                _birthday.value = it
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

    private fun updateUserData(
        userData: FirebaseUser
    ){
        _user.update {
            it.copy(
                photoUrl = userData.photoUrl.toString(),
                name = userData.displayName?:"No Data",
                email = userData.email?:"No Data",
                phoneNumber = userData.phoneNumber?:"",
                bio = "",
                birthday = "",
                gender = ""
            )
        }
    }

}