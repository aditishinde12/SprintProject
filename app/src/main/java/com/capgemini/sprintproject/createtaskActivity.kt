package com.capgemini.sprintproject

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
//import com.capgemini.sprintproject.model.DateConverter
import java.text.SimpleDateFormat
import java.util.*

class createtaskActivity : AppCompatActivity() {

    lateinit var startdateEdt: EditText
    lateinit var dueDateEdt: EditText
    lateinit var taskNameEdt: EditText
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createtask)

        startdateEdt = findViewById(R.id.startDateT)
        dueDateEdt=findViewById(R.id.dueDateT)
        taskNameEdt=findViewById(R.id.taskNameT)
        saveButton=findViewById(R.id.saveB)

        startdateEdt.setOnClickListener{
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { view: DatePicker, year:Int, monthOfYear:Int, dayOfMonth:Int ->
                    // setting date to our edit text.
//                    val sdate = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
//                    startdateEdt.setText(sdate)
                    val sDate= Calendar.getInstance()
                    sDate.set(year,monthOfYear,dayOfMonth)

                    val dateFormat= SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val formattedDate=dateFormat.format(sDate.time)

                    startdateEdt.setText(formattedDate)
                   // var startDate= DateConverter().fromTimestamp(formattedDate)


                },
                //passing year, month and day for the selected date in our date picker.
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        dueDateEdt.setOnClickListener {

            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { view, year, monthOfYear, dayOfMonth ->
                    //setting date to our edit text.
                    val dDate= Calendar.getInstance()
                    dDate.set(year,monthOfYear,dayOfMonth)

                    val dateFormat= SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val formattedDate=dateFormat.format(dDate.time)

                    dueDateEdt.setText(formattedDate)
                   // var dueDate= DateConverter().fromTimestamp(formattedDate)
                },
                //passing year, month and day for the selected date in our date picker.
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        saveButton.setOnClickListener {
            if(taskNameEdt.text.toString().isNotEmpty() && startdateEdt.text.toString().isNotEmpty() && dueDateEdt.text.toString().isNotEmpty())
                //findNavController(R.id.createtaskActivity).navigate(R.id.taskList)

            else
            {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_LONG).show()
                //Snackbar.make(this, "Enter all fields", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}