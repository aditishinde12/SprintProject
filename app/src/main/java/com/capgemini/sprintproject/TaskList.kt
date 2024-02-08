package com.capgemini.sprintproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskList : AppCompatActivity() {
    lateinit var rView: RecyclerView
    val taskList = mutableListOf<Task>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        rView = findViewById(R.id.rView)
        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = TaskAdapter(taskList) {
            Toast.makeText(this, "Selected task:${taskList[it].taskName}", Toast.LENGTH_LONG).show()

    }
        populateData()}

    fun populateData()
    {
        taskList.add(Task("Eat","22-01-21","22-02-21","high",true))
        taskList.add(Task("Play","04-12-18","12-03-09","low",true))
        taskList.add(Task("dance","04-12-18","04-12-18","low",true))


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.filterandsort_menu, menu)
        val searchV = menu?.findItem(R.id.app_bar_search)?.actionView as SearchView
        val myTextListener = object : SearchView.OnQueryTextListener {
           /* fun onQueryTextSearch(query: String?): Boolean {
                Log.d("MainActivity", "Search:$query")
                val filteredList = taskList.filter {
                    it.taskName.startsWith(query ?: "Not Found", true)
                }
                if (taskList.isNotEmpty()) {
                    rView.adapter = TaskAdapter(filteredList as MutableList<Task>) {

                    }
                }
                return true
            }
            */


            override fun onQueryTextSubmit(query: String?): Boolean {

                Log.d("MainActivity", "Search:$query")
                val filteredList = taskList.filter {
                    it.taskName.startsWith(query ?: "Not Found", true)
                }
                if (taskList.isNotEmpty()) {
                    rView.adapter = TaskAdapter(filteredList as MutableList<Task>) {

                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("searchtask", "Search changed:$newText")
                return true
            }

        }
        searchV.setOnQueryTextListener(myTextListener)
        searchV.setOnCloseListener {
            rView.adapter =TaskAdapter(taskList) {

            }
            false
        }
        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.date_item -> {
                //sort by date
                taskList.sortBy { it.endDate }
                rView.adapter?.notifyDataSetChanged()
            }
            R.id.priority_item_high->{
                taskList.filter {it.priority=="high"}
                rView.adapter?.notifyDataSetChanged()
            }
            R.id.priority_item_low->{
                taskList.filter {it.priority=="low"}
                rView.adapter?.notifyDataSetChanged()
            }

        }

        return super.onOptionsItemSelected(item)
    }
}