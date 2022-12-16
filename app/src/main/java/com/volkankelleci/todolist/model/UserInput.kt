package com.volkankelleci.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinput")
data class UserInput(
    val title:String,
    val explain:String,
){
    @PrimaryKey(autoGenerate = true) //ROOM icin
    var uuid:Int=0
}
