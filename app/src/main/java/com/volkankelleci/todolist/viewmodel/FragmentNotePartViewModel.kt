package com.volkankelleci.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.volkankelleci.todolist.model.UserInput

class FragmentNotePartViewModel(application: Application):CoroutineBaseViewModel(application){
    val title=MutableLiveData<List<UserInput>>()
    val todo = MutableLiveData<List<UserInput>>()


}