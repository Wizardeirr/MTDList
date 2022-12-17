package com.volkankelleci.todolist.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.volkankelleci.todolist.model.UserInput

@Database(entities = [UserInput::class], version = 1)
abstract class toDoListDataBase :RoomDatabase(){

    abstract fun Dao():UserDao


    companion object{
        //Volatile diğer tredlere de görünür yapar.
        @Volatile private var instance:toDoListDataBase?=null
        private val lock=Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance?: dataBaseOlustur(context).also {
                instance=it

            }
        }
        //invoke = ateşlemek başlatmak , senkronize bir şekilde instance oluşturulduysa onu döndür,
        //eğer oluşturulmadıysa senkronize yap.
        //instance?: = Elvis Operatürü.
        private fun dataBaseOlustur(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            toDoListDataBase::class.java,"besinDataBase").build()
    }
}

