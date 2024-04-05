package com.taggar.dizi.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun Any.TAG() = this.javaClass.simpleName.toString()

fun Context.readRaw(resId: Int): String {
    var data = ""
    try {
        val inputStream = resources.openRawResource(resId)
        val reader = BufferedReader(InputStreamReader(inputStream))
        while (true) {
            val line = reader.readLine() ?: break
            data += line
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return data
}

inline fun <reified T> String.to(): T {
    val gson = Gson()
    return gson.fromJson(this, T::class.java)
}

inline fun <reified T> String.toType(): T {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(this, type)
}

inline fun <reified T> String.toList(): T {
    val gson = Gson()
    val itemType = object : TypeToken<List<T>>() {}.type
    return gson.fromJson(this, itemType) as T
}

fun Activity.openAppDetails() {
    val intent = Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    )
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Date.formatTo(format: String): String {
    val toFormat = SimpleDateFormat(format)
    return toFormat.format(this)
}

fun String.toDate(format: String): Date? {
    try {
        val toFormat = SimpleDateFormat(format)
        return toFormat.parse(this)
    } catch (e: Exception) {
        return null
    }
}


fun String.asUriToPath(context: Context): String? {
    if (startsWith("content")) {
        try {
            val cursor = context.contentResolver
                .query(
                    Uri.parse(this), arrayOf(MediaStore.Files.FileColumns.DATA),
                    null, null, null
                )
            cursor?.moveToFirst()
            val filePath = cursor?.getString(0)
            cursor?.close()
            return filePath ?: this
        } catch (e: Exception) {
            e.printStackTrace()
            return this
        }

    } else return this
}

fun String.titleCase() = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(
        Locale.getDefault()
    ) else it.toString()
}
