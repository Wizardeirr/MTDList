package com.volkankelleci.todolist.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.volkankelleci.todolist.model.UserInput

@Database(entities = [UserInput::class], version = 1)
abstract class ArtDatabase :RoomDatabase(){
    abstract fun Dao():UserDao
}
