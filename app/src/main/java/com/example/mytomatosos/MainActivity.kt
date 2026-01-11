package com.example.mytomatosos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.productImage)
        val textView: TextView = findViewById(R.id.productName)

        // Load JSON from assets
        val inputStream = assets.open("product.json")
        val jsonText = inputStream.bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonText)

        val productName = jsonObject.getString("name")
        val productImageUrl = jsonObject.getString("imageUrl")

        // Set product name
        textView.text = productName

        // Load image using Coil
        imageView.load(productImageUrl) {
            placeholder(R.drawable.placeholder) // loading somoy dekhabe
            error(R.drawable.error_image)       // load fail hole dekhabe
        }
    }
}
