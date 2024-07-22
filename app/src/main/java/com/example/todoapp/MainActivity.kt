package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.TaskCategory.*

class MainActivity : ComponentActivity() {

    private val categories = listOf(
        Job,
        Personal,
        Other
    )

    private val  tasks = mutableListOf(
        Task("Prueba job", Job),
        Task("Prueba personal", Personal),
        Task("Prueba otro", Other)
    )
    private lateinit var rvCategories : RecyclerView
    private lateinit var categoriesAdapter:CategoriesAdapter
    private lateinit var rvTasks:RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_activity)

        initComponent()
        initUI()

    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

}