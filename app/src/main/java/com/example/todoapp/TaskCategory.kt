package com.example.todoapp

sealed class TaskCategory {
    object Personal : TaskCategory()
    object Job : TaskCategory()
    object Other : TaskCategory()
}

