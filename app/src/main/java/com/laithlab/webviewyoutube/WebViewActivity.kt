package com.laithlab.webviewyoutube

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : ThemeActivity() {

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

            loadDataWithBaseURL(
                "https://google.com",
                html,
                "text/html; charset=utf-8",
                "UTF-8",
                ""
            )
        }
    }
}