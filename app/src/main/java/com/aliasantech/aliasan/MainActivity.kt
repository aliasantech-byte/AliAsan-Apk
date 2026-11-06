
package com.aliasantech.aliasan

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(245, 247, 255))
        }

        val title = TextView(this).apply {
            text = "علی آسان"
            textSize = 34f
            setTextColor(Color.rgb(25, 75, 180))
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "آموزش کامپیوتر و فناوری\nسریع و آسان"
            textSize = 20f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 24)
        }

        layout.addView(title)
        layout.addView(subtitle)

        setContentView(layout)
    }
}
