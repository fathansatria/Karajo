package com.genesys.karajo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class Webview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        var url = intent.getStringExtra("url")

        foto_web_view.loadUrl(url)
        foto_web_view.webViewClient = WebViewClient()


    }
}
