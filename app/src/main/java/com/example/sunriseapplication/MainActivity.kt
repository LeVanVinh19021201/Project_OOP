package com.example.sunriseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunriseapplication.presentation.helper.NavigationManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationManager.getInstance().init(this, supportFragmentManager, R.id.fragment_container)
    }
}