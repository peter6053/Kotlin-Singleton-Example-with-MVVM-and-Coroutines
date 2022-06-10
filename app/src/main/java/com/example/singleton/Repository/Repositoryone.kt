package com.example.singleton.Repository

import androidx.lifecycle.LiveData
import com.example.singleton.api.MyRetrofitBuilder
import com.example.singleton.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repositoryone {
    var job: CompletableJob? = null

    fun getUserID(userId: String): LiveData<User> {
        job = Job()
        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let { thejob ->
                    CoroutineScope(IO + thejob).launch {
                        val user = MyRetrofitBuilder.apiService.getuser(userId)
                        withContext(Main) {
                            value = user
                            thejob.complete()
                        }
                    }
                }
            }


        }
        fun Canceljobs() {
            job?.cancel()
        }

    }
}