package com.volkankelleci.todolist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "userinput")
data class UserInput(
    @PrimaryKey(autoGenerate = true) //ROOM icin
    val uuid:Int,
    val title:String,
    val explain:String,
):Parcelable
