package com.example.workmanagerexample

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore

class SettingsManager(context: Context) {

    private val dataStore = context.createDataStore(name = "settings_pref")

    companion object {
        val IS_DARK_MODE = preferencesKey<Boolean>("dark_mode")
    }

    suspend fun setUiMode(uiMode:UiMode){

        dataStore.edit { preferences ->
            preferences[IS_DARK_MODE] = when (uiMode){
                UiMode.LIGHT -> false
                UiMode.DARK -> true
            }
        }
    }
}