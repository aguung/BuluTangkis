package com.bulutangkis.apps.utils

import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient


@SuppressLint("SetJavaScriptEnabled")
fun setWeb(web: WebView, url: String) {
    val settings: WebSettings = web.settings
    web.webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }
    }
    web.webChromeClient = WebChromeClient()
    settings.useWideViewPort = true
    settings.loadWithOverviewMode = true
    settings.loadsImagesAutomatically = true
    settings.javaScriptEnabled = true
    settings.domStorageEnabled = true
    settings.builtInZoomControls = true
    settings.databaseEnabled = true
    settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
    settings.setAppCacheEnabled(true)
    web.loadUrl(url)
}