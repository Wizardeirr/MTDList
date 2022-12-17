package com.volkankelleci.todolist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "userinput")
data class UserInput(
    val title:String,
    val explain:String,
):Parcelable{
    @PrimaryKey(autoGenerate = true) //ROOM icin
    var uuid:Int=0
}
