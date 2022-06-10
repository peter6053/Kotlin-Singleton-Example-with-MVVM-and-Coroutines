package com.example.singleton

import com.example.singleton.models.User

object ExampleSingletone {
    val singletoneuser: User by lazy {
        User("mitcheltabian@gmail.com","Mitch","immage.png")
    }

}