package com.example.singleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var ViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        ViewModel.user.observe(this, Observer {user ->
            println("debug ${user}")
        })

        ViewModel.SetUserId("1")


    }

    override fun onDestroy() {
        super.onDestroy()
        ViewModel.Canceljobs()
    }
}