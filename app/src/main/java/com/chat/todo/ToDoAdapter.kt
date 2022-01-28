package com.chat.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.chat.todo.databinding.TodoItemBinding
import com.chat.todo.db.ToDoRepo
import com.chat.todo.model.Todo

class ToDoAdapter(private val todolist: MutableList<Todo>, private val onDone: (String) -> Unit) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       return TodoViewHolder(TodoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.todoText.text = todolist[position].todo_text
        holder.binding.isdonecheck.isChecked = todolist[position].is_done
        holder.binding.isdonecheck.setOnClickListener{
            onDone(todolist[position].todo_text)
        }

    }

    override fun getItemCount(): Int {
        return todolist.size
    }

    fun updateList(v: List<Todo>){
        todolist.clear()
        todolist.addAll(v)
        notifyDataSetChanged()
    }

}

class TodoViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root)

