package com.example.bookstore.data.local

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesService @Inject constructor(private val sharedPreferencesClient: SharedPreferencesClient) {

    private val fieldOU = "o_u"
    private val fieldSessionKey = "sesskey"

    fun saveKeyList(keyList: List<String>) {
        sharedPreferencesClient.editor.putString(fieldOU, keyList[0])
        sharedPreferencesClient.editor.putString(fieldSessionKey, keyList[1])
        sharedPreferencesClient.editor.apply()
    }

    fun getKeyList(): List<String> {
        val oU = sharedPreferencesClient.sharedPreferences.getString(fieldOU, null)
        val sessionKey = sharedPreferencesClient.sharedPreferences.getString(fieldSessionKey, null)

        return if (!oU.isNullOrEmpty() && !sessionKey.isNullOrEmpty()) {
            val keyList = mutableListOf<String>()
            keyList.add(oU)
            keyList.add(sessionKey)
            keyList
        } else {
            emptyList()
        }
    }

    fun removeKeyList() {
        sharedPreferencesClient.editor.remove(fieldOU)
        sharedPreferencesClient.editor.remove(fieldSessionKey)
        sharedPreferencesClient.editor.apply()
    }
}