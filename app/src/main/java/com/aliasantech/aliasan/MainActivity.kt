
package com.aliasantech.aliasan

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private val blue = Color.rgb(25, 65, 155)
    private val yellow = Color.rgb(255, 195, 35)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(245, 247, 252))
        }

        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(20, 28, 20, 30)
        }

        val logo = ImageView(this).apply {
            setImageResource(R.drawable.logo)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }

        val logoParams = LinearLayout.LayoutParams(180, 180)
        logoParams.gravity = Gravity.CENTER
        content.addView(logo, logoParams)

        val title = TextView(this).apply {
            text = "علی آسان"
            textSize = 32f
            setTextColor(blue)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "دنیای آموزش سریع و آسان"
            textSize = 17f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 24)
        }

        content.addView(title)
        content.addView(subtitle)

        addCard(content, "آموزش ویندوز",
            "ترفندها و آموزش‌های کاربردی ویندوز")

        addCard(content, "آموزش کامپیوتر",
            "مهارت‌های کاربردی دنیای کامپیوتر")

        addCard(content, "فایل‌های آموزشی رایگان",
            "دریافت ابزارها و فایل‌های آموزش")

        val telegram = Button(this).apply {
            text = "ورود به کانال تلگرام"
            setTextColor(Color.WHITE)
            setBackgroundColor(blue)
            setOnClickListener {
                openLink("https://t.me/AliMazidi_Official")
            }
        }

        content.addView(telegram)

        val footer = TextView(this).apply {
            text = "علی آسان | سریع و آسان"
            textSize = 14f
            setTextColor(blue)
            gravity = Gravity.CENTER
            setPadding(0, 28, 0, 8)
        }

        content.addView(footer)
        scroll.addView(content)
        root.addView(scroll)
        setContentView(root)
    }

    private fun addCard(
        parent: LinearLayout,
        heading: String,
        description: String
    ) {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(20, 18, 20, 18)
            setBackgroundColor(Color.WHITE)
        }

        val title = TextView(this).apply {
            text = heading
            textSize = 20f
            setTextColor(blue)
            typeface = Typeface.DEFAULT_BOLD
        }

        val detail = TextView(this).apply {
            text = description
            textSize = 14f
            setTextColor(Color.DKGRAY)
            setPadding(0, 8, 0, 0)
        }

        card.addView(title)
        card.addView(detail)

        card.setOnClickListener {
            Toast.makeText(
                this,
                "این بخش به زودی فعال می‌شود",
                Toast.LENGTH_SHORT
            ).show()
        }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 8, 0, 14)
        parent.addView(card, params)
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = android.net.Uri.parse(url)
        startActivity(intent)
    }
}
