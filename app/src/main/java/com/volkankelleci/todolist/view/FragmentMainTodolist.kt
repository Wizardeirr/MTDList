package com.volkankelleci.todolist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.volkankelleci.todolist.R
import kotlinx.android.synthetic.main.main_fragment_todolist.*

class FragmentMainTodolist:Fragment(R.layout.main_fragment_todolist) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.fragmentNotePart)
        }


    }

}