package com.dat.android.lips.presentation.black

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dat.android.lips.R
import com.dat.android.lips.utils.PreferenceProvider
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity(R.layout.activity_web) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.userAgentString = webView.settings.userAgentString + "MobileAppClient/Android/0.9"
        webView.webViewClient = Client()

        if (PreferenceProvider.getLastURL() == ""){
            var url = PreferenceProvider.getUrl()
            webView.loadUrl(url)
        }else{
            var url = PreferenceProvider.getLastURL()
            webView.loadUrl(url)
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }


}