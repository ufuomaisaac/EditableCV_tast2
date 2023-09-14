package com.example.cvproject_task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cvproject_task2.databinding.ActivityEditCvactivityBinding

class EditCVActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditCvactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCvactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        intent.also {
            binding.fullNameEdit.setText(it.getStringExtra("fullname"))
            binding.slackUserNameEdit.setText(it.getStringExtra("slackname"))
            binding.githubhandleEdit.setText(it.getStringExtra("githubhandle"))
            binding.personalBioEdit.setText(it.getStringExtra("personalbio"))
        }

        binding.saveChangesButton.setOnClickListener {

            Intent(this, MainActivity::class.java).also{
                var fullName = binding.fullNameEdit.text.toString()
                var slackName = binding.slackUserNameEdit.text.toString()
                var githubHandle = binding.githubhandleEdit.text.toString()
                var personalBio = binding.personalBioEdit.text.toString()
                it.putExtra("fullname", fullName)
                it.putExtra("slackname", slackName)
                it.putExtra("githubhandle", githubHandle)
                it.putExtra("personalbio", personalBio)
                startActivity(it)
            }
        }


    }
}