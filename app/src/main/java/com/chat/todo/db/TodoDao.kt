package com.chat.todo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.chat.todo.model.Todo

@Dao
interface TodoDao {
    @Query("INSERT INTO Todo VALUES (:text,:booldone)")
    fun insertTodo(text: String,booldone: Boolean)

    @Query("UPDATE Todo SET is_done = ~is_done WHERE todo_text =(:text)")
    fun updateTodo(text: String)

    @Query("SELECT * FROM Todo")
    fun fetchtodo(): LiveData<List<Todo>>
}