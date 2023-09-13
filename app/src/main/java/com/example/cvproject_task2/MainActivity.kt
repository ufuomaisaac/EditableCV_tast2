package com.example.cvproject_task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cvproject_task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var parentView = binding.root
        setContentView(parentView)

        binding.editCV.setOnClickListener {
            Intent(this, EditCVActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}