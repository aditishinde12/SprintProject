package com.capgemini.sprintproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(val listOfTask:MutableList<Task>, val onSelection:(Int)->Unit) :
    RecyclerView.Adapter<TaskAdapter.TaskHolder>() {
        inner class TaskHolder(view: View): RecyclerView.ViewHolder(view)
        { init{view.setOnClickListener{
            Log.d("taskAdapter","Position:${this.adapterPosition}")
            onSelection(adapterPosition)
        }}

            val taskNameTextView: TextView =view.findViewById(R.id.taskNameT)
            val priorityTextView: TextView =view.findViewById(R.id.priorityT)
            val endDateTextView:TextView=view.findViewById(R.id.endDateT)


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val inflatedView= LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)//inflate returns root view that is card view
        return TaskHolder(inflatedView)

    }

    override fun getItemCount(): Int {
        Log.d("TaskAdapter","${listOfTask.size}")
        return listOfTask.size
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val task=listOfTask[position]
     /* if(status==true)
            (holder.itemView as CardView).setCardBackgroundColor(Color.BLUE)
         else
          (holder.itemView as CardView).setCardBackgroundColor(Color.)
      */

        holder.taskNameTextView.text=task.taskName
        holder.priorityTextView.text=task.priority
        //holder.endDateTextView.text="${task.endDate}
        holder.endDateTextView.text=task.endDate

    }

    }