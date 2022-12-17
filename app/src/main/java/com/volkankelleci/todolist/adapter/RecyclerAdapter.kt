package com.volkankelleci.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.todolist.R
import com.volkankelleci.todolist.model.UserInput
import com.volkankelleci.todolist.view.FragmentMainTodolistDirections
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(var UserInputs:List<UserInput>): RecyclerView.Adapter<RecyclerAdapter.UserVH>() {

    class UserVH (var itemView:View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val layout=LayoutInflater.from(parent.context)
        val view=layout.inflate(R.layout.recycler_row,parent,false)
        return UserVH(view)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.itemView.enterTitle.text=UserInputs[position].title
        holder.itemView.EnterToDo.text=UserInputs[position].explain
        holder.itemView.raw_layout_id.setOnClickListener{
            val action=FragmentMainTodolistDirections.actionFragmentMainTodolistToUpdateFragment(UserInputs.get(position))
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return UserInputs.size
    }
    fun setData(user:List<UserInput>){
        this.UserInputs=user
        notifyDataSetChanged()
    }
}