package com.volkankelleci.todolist.view

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.volkankelleci.todolist.R
import com.volkankelleci.todolist.databinding.FragmentUpdateBinding
import com.volkankelleci.todolist.model.UserInput
import com.volkankelleci.todolist.viewmodel.FragmentNotePartViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import kotlin.math.exp

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var viewModel: FragmentNotePartViewModel
    private var binding:FragmentUpdateBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        viewModel=ViewModelProvider(this).get(FragmentNotePartViewModel::class.java)
        val binder=FragmentUpdateBinding.bind(view)
        binding=binder
        binder.updateTitleText.setText(args.currentUser.title)
        binder.updatetodoText.setText(args.currentUser.explain)

        view.updateverifyImage.setOnClickListener {
        updateItem()
        }

        return binder.root

    }

    private fun updateItem() {

        val titleName = updateTitleText.text.toString()
        val explain = updatetodoText.text.toString()
        if (inputCheck(titleName, explain)) {
            //Create user infos
            val updateUser = UserInput(args.currentUser.uuid,titleName,explain)
            //add Data to DB
            viewModel.updateUser(updateUser)
            findNavController().navigate(R.id.action_updateFragment_to_fragmentMainTodolist)
            Toast.makeText(requireContext(),"Update Successfully",Toast.LENGTH_SHORT).show()


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