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
        val USER_INFO_KEY = stringPreferencesKey("user_info")
    }

    val getUserInfo: Flow<String> = context.dataStore.data
        .map {  preferences ->
            preferences[USER_INFO_KEY]?:""
        }

    suspend fun saveInfo(
        userInfo: String
    ){
        context.dataStore.edit {
            it[USER_INFO_KEY] = userInfo
        }
    }
}