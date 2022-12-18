package com.volkankelleci.todolist.view

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.volkankelleci.todolist.R
import com.volkankelleci.todolist.databinding.FragmentNotePartBinding
import com.volkankelleci.todolist.model.UserInput
import com.volkankelleci.todolist.viewmodel.FragmentNotePartViewModel
import kotlinx.android.synthetic.main.fragment_note_part.*
import kotlinx.android.synthetic.main.fragment_note_part.view.*

class FragmentNotePart : Fragment(R.layout.fragment_note_part) {

    private lateinit var viewModel: FragmentNotePartViewModel
    private var binding: FragmentNotePartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val view = inflater.inflate(R.layout.fragment_note_part, container, false)
        val binder=FragmentNotePartBinding.bind(view)
        binding=binder
        binder.verifyImage.setOnClickListener {
            insertToDataBase()
        }
        viewModel = ViewModelProvider(this).get(FragmentNotePartViewModel::class.java)
        return binder.root


    }

    private fun insertToDataBase() {
        val titleName = titleText.text.toString()
        val todoStep = todoText.text.toString()
        if (inputCheck(titleName, todoStep)) {
            //Create user infos
            val user = UserInput(0, titleName, todoStep)
            //add Data to DB
            viewModel.addUser(user)
            findNavController().navigate(R.id.action_fragmentNotePart_to_fragmentMainTodolist)
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(requireContext(), "Error,Please Enter title and todo", Toast.LENGTH_LONG)
                .show()
        }


    }

    private fun inputCheck(titleName: String, todoStep: String): Boolean {
        return !(TextUtils.isEmpty(titleName) && TextUtils.isEmpty(todoStep))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}