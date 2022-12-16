package com.volkankelleci.todolist.repo

import androidx.lifecycle.LiveData
import com.bumptech.glide.load.engine.Resource
import com.volkankelleci.todolist.model.UserInput

interface InputRepositoryIF{
    suspend fun addUser(inputs: List<UserInput>)
    suspend fun deleteAll(inputs:UserInput)
    fun readAllDatas(): LiveData<List<UserInput>>

}