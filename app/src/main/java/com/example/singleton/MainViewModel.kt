package com.example.singleton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.singleton.Repository.Repositoryone
import com.example.singleton.models.User

class MainViewModel : ViewModel(){
    private val _Userid: MutableLiveData<String> = MutableLiveData()

    val user: LiveData<User> = Transformations
        .switchMap(_Userid){
            Repositoryone.getUserID(it)
        }

    fun SetUserId(Userid : String){
        val update = Userid
        if (_Userid.value == update){
            return
        }
        _Userid.value = update


    }
fun Canceljobs (){
   // Repositoryone.Cancelobs()
}
}