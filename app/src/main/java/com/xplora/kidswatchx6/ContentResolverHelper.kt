package com.xplora.kidswatchx6

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

class ContentResolverHelper(private val context: Context) {
    companion object {
        const val PROVIDER_NAME = "com.xplora.kidswatchx6.database.provider"
        const val TABLE_NAME = "Badge"
        const val URL = "content://$PROVIDER_NAME/$TABLE_NAME"
        val CONTENT_URI = Uri.parse(URL)
    }

    private var contentResolver: ContentResolver = context.contentResolver

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAll() {
        val cursor = contentResolver.query(CONTENT_URI, null, null, null)
        cursor?.let {
            while (it.moveToNext()) {
                Log.i("tung", "_id: ${it.getString(0)}")
                Log.i("tung", "id: ${it.getString(1)}")
                Log.i("tung", "name: ${it.getString(2)}")
                Log.i("tung", "badges: ${it.getString(3)}")
            }
        }
        cursor?.close()
    }
}