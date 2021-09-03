package com.example.kotlinshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinshop.R
import com.example.kotlinshop.uitel.getProgressDrawable
import com.example.kotlinshop.uitel.loadImage
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)


        val scooterIntent = intent


        val scooterTitle = scooterIntent.getStringExtra("title")
        val scooterDescription = scooterIntent.getStringExtra("description")
        val scooterImg = scooterIntent.getStringExtra("img")
        val scooterPrice = scooterIntent.getStringExtra("price")

        new_title.text = scooterTitle
        new_description.text = scooterDescription
        new_price.text = scooterPrice
        new_imageview.loadImage(scooterImg, getProgressDrawable(this))

    }
}