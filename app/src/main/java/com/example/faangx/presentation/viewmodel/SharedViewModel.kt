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
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
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
        userInfo: User
    ):Boolean{
        return (
            userInfo.name.isNotEmpty() &&
            userInfo.phoneNumber.isNotEmpty() &&
            userInfo.email.isNotEmpty() &&
            userInfo.photoUrl.isNotEmpty() &&
            userInfo.gender.isNotEmpty() &&
            userInfo.bio.isNotEmpty() &&
            userInfo.birthday.isNotEmpty()
        )
    }

    fun onSignInResult(
        result: FirebaseAuthUIAuthenticationResult,
        navigateToEditProfileScreen: () -> Unit,
        datastore: LoginDatastoreRepository) {
        viewModelScope.launch{
            if (result.resultCode == ComponentActivity.RESULT_OK) {
                // Successfully signed in
                val userData = FirebaseAuth.getInstance().currentUser

                checkUsers(getFirebaseUser(userData!!), datastore, navigateToEditProfileScreen)

            } else {
                Log.d("Failed", "no message")
            }
        }
    }

    private fun getFirebaseUser(userData: FirebaseUser):User{
        var userObject = User(
            photoUrl = userData.photoUrl?.toString() ?:"",
            name = userData.displayName?:"No Data",
            email = userData.email?:"No Data",
            phoneNumber = userData.phoneNumber?:"",
            bio = "",
            birthday = "",
            gender = ""
        )

        return userObject
    }

    private fun saveLogin(datastore: LoginDatastoreRepository, userData: User){
        viewModelScope.launch {
            datastore.saveInfo(
                userInfo = Gson().toJson(userData)
            )
            Log.d("saveLogin", userData.name)
        }
    }

    private fun checkUsers(user: User, datastore: LoginDatastoreRepository, navigateToEditProfileScreen: () -> Unit){
        viewModelScope.launch{
            db.collection("users")
                .whereEqualTo("email", user.email)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        saveLogin(datastore, document.toObject<User>())
                        Log.d("checkUsers", "${document.toObject<User>()}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("checkUsers", "Error getting documents: ", exception)
                }.await()
            updateUserData(user)
            navigateToEditProfileScreen()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveEditProfile(
        datastore: LoginDatastoreRepository,
        userInfo: User
    ){
        viewModelScope.launch {
            datastore.saveInfo(
                userInfo = Gson().toJson(userInfo)
            )
            db.collection("users")
                .add(userInfo).await()
        }
    }

    fun getLogin(datastore: LoginDatastoreRepository){
        setUserInfo(datastore)
    }

    fun checkLoggerBool():Boolean{
        return isLogged.value
    }

    private fun setUserInfo(datastore: LoginDatastoreRepository) {
        viewModelScope.launch {
            datastore.getUserInfo.collect { userInfo ->
                Log.d("setUserInfo", "${ userInfo.isEmpty() }")
                if(userInfo.isEmpty()){
                    _user.update{
                        it.copy(
                            photoUrl = "",
                            name = "",
                            email = "",
                            phoneNumber = "",
                            bio = "",
                            birthday = "",
                            gender = ""
                        )
                    }
                }
                else {
                    _user.value = Gson().fromJson(userInfo, User::class.java)
                    Log.d("setUserInfo", "${user.value.bio}")
                }
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
        userData: User
    ){
        _user.update {
            it.copy(
                photoUrl = userData.photoUrl ?:"",
                name = userData.name?:"No Data",
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