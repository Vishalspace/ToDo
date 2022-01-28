package com.chat.todo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chat.todo.model.Todo

@Database(entities = [Todo::class], version =1)
abstract class TodoDB : RoomDatabase() {
    abstract fun TodoDao() : TodoDao
}