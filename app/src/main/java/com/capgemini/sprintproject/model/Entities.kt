package com.capgemini.tasktracker.model

import androidx.room.*
import com.capgemini.sprintproject.model.DateConverter
import java.time.LocalDate

@TypeConverters(DateConverter::class)

@Entity(tableName="User")
data class User(
    @PrimaryKey
    @ColumnInfo("user_email")
    val email: String,

    @ColumnInfo("user_password")
    val password: String
)
/*
@Entity(tableName = "Task", foreignKeys = [ForeignKey(entity = User::class, childColumns = ["user_id"], parentColumns = ["task_id"])])
data class Task(
    @PrimaryKey
    @ColumnInfo("task_name")
    val taskName: String,

    @ColumnInfo("user_id")
    val userId: Int,

    @ColumnInfo("task_start_date")
    var startDate: LocalDate,

    @ColumnInfo("task_end_date")
    var endDate: LocalDate,

    @ColumnInfo("task_priority")
    var priority: String,

    @ColumnInfo("task_status")
    var status: Boolean,

    @ColumnInfo("task_description")
    var Description: String                    //later change it to checkpoints
)
*/
