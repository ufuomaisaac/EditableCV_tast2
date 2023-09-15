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

           /* binding.fullNameEdit.setText(it.getStringExtra("fullname"))
            binding.slackUserNameEdit.setText(it.getStringExtra("slackname"))
            binding.githubhandleEdit.setText(it.getStringExtra("githubhandle"))
            binding.personalBioEdit.setText(it.getStringExtra("personalbio"))*/
        }

        binding.saveChangesButton.setOnClickListener {
           /* var fullName = binding.fullNameEdit.text.toString()
            var slackName = binding.slackUserNameEdit.text.toString()
            var githubHandle = binding.githubhandleEdit.text.toString()
            var personalBio = binding.personalBioEdit.text.toString()*/

            var editor = sharedPreferences.edit()
            editor.putString("fullname", binding.fullNameEdit.text.toString())
            editor.putString("slackname", binding.slackUserNameEdit.text.toString())
            editor.putString("githubhandle",binding.githubhandleEdit.text.toString())
            editor.putString("personalbio", binding.personalBioEdit.text.toString())
            editor.apply()



            Intent(this, MainActivity::class.java).also{
                startActivity(it)
               /* val fullName = binding.fullNameEdit.text.toString()
                val slackName = binding.slackUserNameEdit.text.toString()
                val githubHandle = binding.githubhandleEdit.text.toString()
                val personalBio = binding.personalBioEdit.text.toString()
                it.putExtra("fullname", fullName)
                it.putExtra("slackname", slackName)
                it.putExtra("githubhandle", githubHandle)
                it.putExtra("personalbio", personalBio)
                startActivity(it)*/
            }
        }


    }
}