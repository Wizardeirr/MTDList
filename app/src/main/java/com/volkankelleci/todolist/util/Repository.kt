package com.volkankelleci.todolist.util

import androidx.lifecycle.LiveData
import com.volkankelleci.todolist.model.UserInput
import com.volkankelleci.todolist.roomdb.UserDao

class Repository(private val dao: UserDao) {

    val readData:LiveData<List<UserInput>> = dao.readAllDatas()

    suspend fun addUser(user:UserInput){
        dao.addUser(user)
    }
    suspend fun updateUser(user:UserInput){
        dao.updateUser(user)
    }
    suspend fun deleteUser(user: UserInput){
        dao.deleteAll(user)
    }
}