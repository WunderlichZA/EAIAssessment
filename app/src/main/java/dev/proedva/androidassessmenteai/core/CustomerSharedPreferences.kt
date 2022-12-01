package dev.proedva.androidassessmenteai.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

class CustomerSharedPreferences (context: Context){
    private lateinit var dataStore : DataStore<Preferences>
    init {

    }
}