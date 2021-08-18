package com.laithlab.webviewyoutube

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.activity_webview.view.content

class WebViewActivity : ThemeActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val cssStyle =
            """
                ${resources.getString(R.string.css_content)}
                ${resources.getString(R.string.css_content_positioning)}
            """.trimIndent()
        val body = resources.getString(R.string.html_embedded_content, "https://www.youtube.com/embed/LXb3EKWsInQ")
        // Vimeo embedded player works fine
        // val body = resources.getString(R.string.html_embedded_content, "https://player.vimeo.com/video/583566769")
        val html = resources.getString(R.string.html_content, cssStyle, body)


        content.apply {
            settings.javaScriptEnabled = true

            content.fixPhilologyWebChromeClientCrash()

            loadDataWithBaseURL(
                "https://google.com",
                html,
                "text/html; charset=utf-8",
                "UTF-8",
                ""
            )
        }
    }

    private fun WebView.fixPhilologyWebChromeClientCrash() {
        webChromeClient = object : WebChromeClient() {
            private val crashFixBitmap: Bitmap by lazy {
                Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888).apply {
                    setPixel(0, 0, Color.BLACK)
                }
            }

            override fun getDefaultVideoPoster(): Bitmap = crashFixBitmap
        }
    }
}
