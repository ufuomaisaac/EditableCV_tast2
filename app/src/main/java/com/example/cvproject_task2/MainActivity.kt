package com.example.cvproject_task2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cvproject_task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var parentView = binding.root
        setContentView(parentView)

        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        getPrefValue()

        intent.also {
            getPrefValue()
        }

        binding.editCV.setOnClickListener {
            Intent(this, EditCVActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    fun getPrefValue(){
        var name = sharedPreferences.getString("fullname", null)
        var slackname = sharedPreferences.getString("slackname", null)
        var githubhandle = sharedPreferences.getString("githubhandle", null)
        var personalbio = sharedPreferences.getString("personalbio", null)

        if(name != null || slackname != null || githubhandle != null ) {
            binding.fullNameText.setText(name)
            binding.slackUserNameText.setText(slackname)
            binding.githubhandleText.setText(githubhandle)
            binding.personalBioText.setText(personalbio)
        }
    }
}