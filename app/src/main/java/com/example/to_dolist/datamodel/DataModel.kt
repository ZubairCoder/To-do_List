package com.example.to_dolist.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class DataModel(@PrimaryKey(autoGenerate = true)var Id : Int?,
                     var Title : String,
                     var Detail : String?
)
