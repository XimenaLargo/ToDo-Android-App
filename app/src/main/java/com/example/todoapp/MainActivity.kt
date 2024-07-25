package com.example.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.compose.ui.window.Dialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_activity)

        initComponent()
        initUI()
        initListeners()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter

    }

    private fun initListeners() {
        fabAddTask.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog () {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask : Button = dialog.findViewById(R.id.btnAddTask)
        val etTask : EditText = dialog.findViewById(R.id.etTask)
        val rgCategories : RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener{
            val selectedId = rgCategories.checkedRadioButtonId
            val selectedRadioButton : RadioButton = rgCategories.findViewById(selectedId)
            val currentCategory : TaskCategory =
                when(selectedRadioButton.text){
                    "Job" -> Job
                    "Personal" -> Personal
                    else -> Other
                }
            tasks.add(
                Task(etTask.text.toString(),currentCategory)
            )
            updateTask()
            dialog.hide()
        }
        dialog.show()
    }

    private fun updateTask () {
        tasksAdapter.notifyDataSetChanged()
    }
}