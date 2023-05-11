package com.example.sunriseapplication.view.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sunriseapplication.databinding.M00ActivityAuthBinding

class M00AuthActivity : AppCompatActivity() {
    lateinit var binding: M00ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = M00ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}