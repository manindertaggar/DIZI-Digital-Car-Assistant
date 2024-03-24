package com.taggar.dizi.analytics

interface Analytics {
    fun track(
        eventName: String,
        properties: Map<String, String> = hashMapOf()
    )

    fun setUserProperty(property: String, value: String)

    companion object {
        const val MIXPANEL_KEY = "c4d0ba1fcc3e7e1f30d85c0128b89de3"
    }
}
