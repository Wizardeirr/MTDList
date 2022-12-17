package com.volkankelleci.todolist.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.volkankelleci.todolist.model.UserInput
import com.volkankelleci.todolist.roomdb.toDoListDataBase
import kotlinx.coroutines.launch


class FragmentNotePartViewModel(application: Application):BaseViewModel(application) {

    val UserInputs=MutableLiveData<List<UserInput>>()



    }






