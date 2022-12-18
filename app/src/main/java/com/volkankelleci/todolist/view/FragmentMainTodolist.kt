package com.volkankelleci.todolist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.todolist.R
import com.volkankelleci.todolist.adapter.RecyclerAdapter
import com.volkankelleci.todolist.databinding.MainFragmentTodolistBinding
import com.volkankelleci.todolist.viewmodel.FragmentNotePartViewModel
import kotlinx.android.synthetic.main.main_fragment_todolist.*

class FragmentMainTodolist : Fragment(R.layout.main_fragment_todolist) {

    private lateinit var viewModel: FragmentNotePartViewModel
    private var binding:MainFragmentTodolistBinding?=null
    private val UserAdapter=RecyclerAdapter(arrayListOf())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binder=MainFragmentTodolistBinding.bind(view)
        binding=binder

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.fragmentNotePart)
        }
        userRV.layoutManager=LinearLayoutManager(context)
        userRV.adapter=UserAdapter


        viewModel=ViewModelProvider(this).get(FragmentNotePartViewModel::class.java)
        viewModel.readAllDatas.observe(viewLifecycleOwner, Observer {
          UserAdapter.setData(it)
        })
        val swipeCallback=object :ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val layoutPosition=viewHolder.layoutPosition
                val selectedArt=UserAdapter.UserInputs[layoutPosition]
                viewModel.deleteUser(selectedArt)
            }

        }

        ItemTouchHelper(swipeCallback).attachToRecyclerView(binder.userRV)




    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }

}