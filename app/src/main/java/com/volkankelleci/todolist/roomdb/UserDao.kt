package com.volkankelleci.todolist.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.volkankelleci.todolist.model.UserInput
import javax.inject.Inject

@androidx.room.Dao

interface UserDao {
    @Insert (onConflict =OnConflictStrategy.REPLACE)
    suspend fun addUser(user:UserInput)
    @Update
    suspend fun updateUser(user:UserInput)
    @Delete
    suspend fun deleteAll(user: UserInput)
    @Query("SELECT*FROM userinput") // that name should be as from model of Entity name
    fun readAllDatas(): LiveData<List<UserInput>>
}