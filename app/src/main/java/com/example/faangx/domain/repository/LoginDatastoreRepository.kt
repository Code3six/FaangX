package com.example.faangx.domain.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoginDatastoreRepository(private val context: Context) {

    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserInfo")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_PHOTO_URL_KEY = stringPreferencesKey("user_photo_url")
        val USER_PHONE_KEY = stringPreferencesKey("user_phone")
        val USER_GENDER_KEY = stringPreferencesKey("user_gender")
        val USER_BIO = stringPreferencesKey("user_bio")
        val LOG_KEY = booleanPreferencesKey("user_log")
        val BIRTHDAY_KEY = stringPreferencesKey("user_birthday")
    }

    val getName: Flow<String> = context.dataStore.data
        .map {  preferences ->
            preferences[USER_NAME_KEY]?:""
        }

    val getEmail: Flow<String> = context.dataStore.data
        .map{ preferences ->
            preferences[USER_EMAIL_KEY]?:""
        }

    val getPhoto: Flow<String> = context.dataStore.data
        .map{ preferences ->
            preferences[USER_PHOTO_URL_KEY]?:""
        }

    val getPhone: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[USER_PHONE_KEY]?:""
        }
    val getLog: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[LOG_KEY]?:false
        }
    val getBio: Flow<String> = context.dataStore.data
        .map { prefrences ->
            prefrences[USER_BIO]?:""
        }
    val getGender: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[USER_GENDER_KEY]?:""
        }
    val getBirthday: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[BIRTHDAY_KEY]?:""
        }

    suspend fun saveInfo(
        name: String,
        email: String,
        phone: String,
        photoUrl: String,
        log: Boolean,
        gender: String,
        bio: String,
        birthday: String
    ){
        context.dataStore.edit {
            it[USER_NAME_KEY] = name
            it[USER_EMAIL_KEY] = email
            it[USER_PHOTO_URL_KEY] = photoUrl
            it[USER_PHONE_KEY] = phone
            it[LOG_KEY] = log
            it[USER_GENDER_KEY] = gender
            it[USER_BIO] = bio
            it[BIRTHDAY_KEY] = birthday
        }
    }
}