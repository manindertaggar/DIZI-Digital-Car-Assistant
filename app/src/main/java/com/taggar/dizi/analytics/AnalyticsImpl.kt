package com.taggar.dizi.analytics

import android.content.Context
import android.util.Log
import androidx.core.os.bundleOf
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONObject
import javax.inject.Inject

class AnalyticsImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : Analytics {
    val TAG = "Analytics"

//    private var mixpanelAnalytics = MixpanelAPI.getInstance(context, MIXPANEL_KEY, true)

    override fun track(
        eventName: String, properties: Map<String, String>
    ) {
//        if (BuildConfig.DEBUG) {
//            return
//        }
        var paramsString = ""
        val firebaseBundle = bundleOf()
        val mixpanelJson = JSONObject()
        properties.keys.forEach { key ->
            val value = properties[key]?.lowercase() ?: ""
            paramsString += "\n${key.lowercase()} : $value"
            firebaseBundle.putString(key.lowercase(), value)
            mixpanelJson.put(key, value)
        }

        Log.d(TAG, "analytics track: $eventName $paramsString")
//        firebaseAnalytics.logEvent(eventName, firebaseBundle)
//        mixpanelAnalytics.track(eventName, mixpanelJson)
    }

    override fun setUserProperty(property: String, value: String) {
        Log.d(TAG, "analytics setUserProperty: $property $value")
//        firebaseAnalytics.setUserProperty(property, value)
//        mixpanelAnalytics.people.set(property, value)
    }
}