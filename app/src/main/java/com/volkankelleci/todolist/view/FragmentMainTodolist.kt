package com.volkankelleci.todolist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.RecyclerAdapter
import com.volkankelleci.todolist.R
import com.volkankelleci.todolist.model.UserInput
import com.volkankelleci.todolist.roomdb.UserDao
import com.volkankelleci.todolist.viewmodel.FragmentNotePartViewModel
import kotlinx.android.synthetic.main.main_fragment_todolist.*

class FragmentMainTodolist:Fragment(R.layout.main_fragment_todolist) {

    private lateinit var viewModel:FragmentNotePartViewModel
    private  val Useradapter= com.adapter.RecyclerAdapter(arrayListOf())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.fragmentNotePart)
        }

        viewModel=ViewModelProviders.of(this).get(FragmentNotePartViewModel::class.java)

        userRV.layoutManager=GridLayoutManager(context,1)
        userRV.adapter=Useradapter
        observeLiveData()

    }
    fun observeLiveData(){
        viewModel.UserInputs.observe(viewLifecycleOwner,Observer{
            it?.let {
                userRV.visibility=View.VISIBLE

            }
        })
    }

}