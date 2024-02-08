package com.capgemini.tasktracker.viewmodel

import android.app.Application
import android.app.DownloadManager.Query
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import com.capgemini.tasktracker.model.Task
import com.capgemini.tasktracker.model.TaskRepository
import com.capgemini.tasktracker.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    //owns repository
    private val repo =TaskRepository(application)
 //   var taskList: MutableLiveData<List<Task>> = repo.allTasks as MutableLiveData<List<Task>>
 var isUserAdded= MutableLiveData<Boolean>(false)
    fun insertUser(user: User){
        CoroutineScope(Dispatchers.IO).launch{
          isUserAdded.postValue(repo.insertUser(user))
        }
    }
    fun updateUser(user: User){
        CoroutineScope(Dispatchers.IO).launch{
            repo.updateUser(user)
        }
    }
 /*   fun insertTask(task: Task){
        CoroutineScope(Dispatchers.IO).launch{
            repo.insertTask(task)
        }
    }
    fun updateTask(task: Task){
        CoroutineScope(Dispatchers.IO).launch{
            repo.updateTask(task)
        }
    }
    fun deleteTask(task: Task){
        CoroutineScope(Dispatchers.IO).launch{
            repo.deleteTask(task)
        }
    }
    fun searchTask(query: String): LiveData<List<Task>>{
        return repo.searchTask(query)
    }
    fun getAllTasks(): MutableLiveData<List<Task>>{
        return taskList
    }*/
}