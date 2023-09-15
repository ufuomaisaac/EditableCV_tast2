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

       // val editor = sharedPreferences.edit()

        intent.also {
            getPrefValue()
/*
            editor.apply {
                putString("fullname", it.getStringExtra("fullname"))
                putString("slackname", it.getStringExtra("slackname"))
                putString("githubhandle", it.getStringExtra("githubhandle"))
                putString("personalbio", it.getStringExtra("personalbio"))
                apply()
            }
            getPrefValue()
*/


        }

        binding.editCV.setOnClickListener {
            Intent(this, EditCVActivity::class.java).also {
                startActivity(it)
/*
                var fullName = binding.fullNameText.text.toString()
                var slackName = binding.slackUserNameText.text.toString()
                var githubHandle = binding.githubhandleText.text.toString()
                var personalBio = binding.personalBioText.text.toString()
                it.putExtra("fullname", fullName)
                it.putExtra("slackname", slackName)
                it.putExtra("githubhandle", githubHandle)
                it.putExtra("personalbio", personalBio)
                startActivity(it)*/
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