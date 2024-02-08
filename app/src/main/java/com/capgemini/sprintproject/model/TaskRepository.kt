package com.capgemini.tasktracker.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TaskRepository(application: Application) {
    private val taskTrackerDao: TaskTrackerDAO
 //   val allTasks: LiveData<List<Task>>


    init{
        val db: TaskTrackerDB = TaskTrackerDB.getInstance(application.applicationContext)
        taskTrackerDao = db.taskTrackerDAO()
//        allTasks = taskTrackerDao.getAllTasks()
    }
    suspend fun insertUser(user: User):Boolean{
        var isAdded=false
        try {
            taskTrackerDao.insertUser(user)
            isAdded=true
        }catch (err:Exception){
        isAdded=false}

        return isAdded
    }
    suspend fun updateUser(user: User){
        taskTrackerDao.updateUser(user)
    }
/*    suspend fun insertTask(task: Task){
        taskTrackerDao.insertTask(task)
    }
    suspend fun updateTask(task: Task){
        taskTrackerDao.updateTask(task)
    }
    suspend fun deleteTask(task: Task){
        taskTrackerDao.deleteTask(task)
    }
    fun searchTask(query: String): LiveData<List<Task>>{
        return taskTrackerDao.searchTask("%query%")
    }
    suspend fun getAllTasks(): LiveData<List<Task>>{
        return allTasks
    }*/
}