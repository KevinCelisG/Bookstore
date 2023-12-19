package com.example.bookstore.data.local

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesService @Inject constructor(private val sharedPreferencesClient: SharedPreferencesClient) {

    // Keys for storing values in SharedPreferences.
    private val fieldOU = "o_u"
    private val fieldSessionKey = "sesskey"

    /**
     * Saves a list of keys to SharedPreferences.
     * @param keyList The list of keys to be saved.
     */
    fun saveKeyList(keyList: List<String>) {
        sharedPreferencesClient.editor.putString(fieldOU, keyList[0])
        sharedPreferencesClient.editor.putString(fieldSessionKey, keyList[1])
        sharedPreferencesClient.editor.apply()
    }

    /**
     * Gets a list of keys from SharedPreferences.
     * @return A list of keys, or an empty list if keys are not present.
     */
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

    /**
     * Removes the stored key list from SharedPreferences.
     */
    fun removeKeyList() {
        sharedPreferencesClient.editor.remove(fieldOU)
        sharedPreferencesClient.editor.remove(fieldSessionKey)
        sharedPreferencesClient.editor.apply()
    }
}