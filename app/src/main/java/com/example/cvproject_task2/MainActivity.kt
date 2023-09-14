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

        intent.also {
            binding.fullNameText.text = it.getStringExtra("fullname")
            binding.slackUserNameText.text = it.getStringExtra("slackname")
            binding.githubhandleText.text = it.getStringExtra("githubhandle")
            binding.personalBioText.text = it.getStringExtra("personalbio")
        }

        binding.editCV.setOnClickListener {
            Intent(this, EditCVActivity::class.java).also {

                var fullName = binding.fullNameText.text.toString()
                var slackName = binding.slackUserNameText.text.toString()
                var githubHandle = binding.githubhandleText.text.toString()
                var personalBio = binding.personalBioText.text.toString()
                it.putExtra("fullname", fullName)
                it.putExtra("slackname", slackName)
                it.putExtra("githubhandle", githubHandle)
                it.putExtra("personalbio", personalBio)
                startActivity(it)
            }
        }
    }
}