package com.example.cvproject_task2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cvproject_task2.databinding.ActivityEditCvactivityBinding

class EditCVActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditCvactivityBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCvactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        intent.also {
            getPrefValue()
        }

        binding.saveChangesButton.setOnClickListener {
            var editor = sharedPreferences.edit()
            editor.putString("fullname", binding.fullNameEdit.text.toString())
            editor.putString("slackname", binding.slackUserNameEdit.text.toString())
            editor.putString("githubhandle",binding.githubhandleEdit.text.toString())
            editor.putString("personalbio", binding.personalBioEdit.text.toString())
            editor.apply()

            Intent(this, MainActivity::class.java).also{
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
            binding.fullNameEdit.setText(name)
            binding.slackUserNameEdit.setText(slackname)
            binding.githubhandleEdit.setText(githubhandle)
            binding.personalBioEdit.setText(personalbio)
        }
    }
}