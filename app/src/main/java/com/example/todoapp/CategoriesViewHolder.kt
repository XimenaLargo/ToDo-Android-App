package com.example.todoapp

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private  val divider:View = view.findViewById(R.id.divider)

    fun render (taskCategory: TaskCategory){
       when(taskCategory){
           TaskCategory.Job -> {
               tvCategoryName.text = "Trabajo"
           }
           TaskCategory.Other -> {
               tvCategoryName.text = "Otros"
           }
           TaskCategory.Personal ->  {
               tvCategoryName.text = "Personales"
           }
       }
    }
}