package com.example.to_dolist.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.to_dolist.datamodel.DataModel

@Dao
interface DataDao {
    @Insert
    fun  dataInsert(dataModel: DataModel)

    @Query("SELECT * FROM todo_table")
    fun getAllData() : LiveData<List<DataModel>>

    @Query("SELECT * FROM todo_table where id like :id limit 1")
    fun getOneData(id : Int) : DataModel

    @Update
    fun updateData(dataModel: DataModel)

    @Delete
    fun deleteData(dataModel: DataModel)

}