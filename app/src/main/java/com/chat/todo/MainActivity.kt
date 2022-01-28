package com.chat.todo

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chat.todo.db.ToDoRepo
import com.chat.todo.model.Todo

class MainActivity : AppCompatActivity() {

    lateinit var repo: ToDoRepo
    val adapter = ToDoAdapter(mutableListOf()) { repo.updateTodo(it) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyleviewtodos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        repo = ToDoRepo(context = this)
        repo.fetchTodo().observe(this){
            if (it != null) {
                adapter.updateList(it)
            }
        }
        val todotext : EditText = findViewById(R.id.todo_add)
        val buttonadd : ImageButton = findViewById(R.id.btn_add)
        buttonadd.setOnClickListener{
            if(todotext.text.toString().trim().isNotEmpty()){
            repo.insertTodo(todotext.text.toString(),false)
            Toast.makeText(applicationContext,"Successfully added!", Toast.LENGTH_SHORT).show()
                todotext.setText("")
            }else{
                Toast.makeText(applicationContext,"Add a ToDo First!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}