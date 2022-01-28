package com.chat.todo.db


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.chat.todo.model.Todo

class ToDoRepo(context: Context) {
    private val todoDao = getdb(context).TodoDao()

    fun insertTodo(todo: String,booldone: Boolean){
        todoDao.insertTodo(todo,booldone)
    }
    fun updateTodo(isdone : String){
        todoDao.updateTodo(isdone)
    }
    fun fetchTodo() : LiveData<List<Todo>> {
        return todoDao.fetchtodo()
    }

    private
    fun getdb(context: Context) : TodoDB {
        return Room.databaseBuilder(context,TodoDB::class.java,"todo.db").run{allowMainThreadQueries()}.build()
    }

}