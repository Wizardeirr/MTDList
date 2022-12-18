package com.volkankelleci.todolist.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.volkankelleci.todolist.model.UserInput
import com.volkankelleci.todolist.roomdb.UserDao
import com.volkankelleci.todolist.roomdb.toDoListDataBase
import com.volkankelleci.todolist.util.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class FragmentNotePartViewModel@Inject constructor(application: Application):AndroidViewModel(application) {

    val readAllDatas:LiveData<List<UserInput>>
    private val repository:Repository

    init {
        val dao=toDoListDataBase.invoke(application).Dao()
        repository=Repository(dao)
        readAllDatas=repository.readData
    }
    fun addUser (user:UserInput){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
    fun updateUser(user:UserInput){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
    fun deleteUser(user: UserInput){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }


    }






