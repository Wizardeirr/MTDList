package com.volkankelleci.todolist.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.volkankelleci.todolist.model.UserInput

@androidx.room.Dao
interface UserDao {
    @Insert (onConflict =OnConflictStrategy.REPLACE)
    suspend fun addUser(user:UserInput)
    @Delete
    suspend fun deleteAll(list:List<UserInput>)
    @Query("SELECT*FROM userinput") // that name should be as from model of Entity name
    fun readAllDatas(): LiveData<List<UserInput>>
}