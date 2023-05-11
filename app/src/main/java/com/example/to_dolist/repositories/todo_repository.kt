package com.example.to_dolist.repositories

import com.example.to_dolist.datamodel.DataModel
import com.example.to_dolist.db.AppDatabase

class todo_repository {
    private val db : AppDatabase?= null
    suspend fun insert(dataModel: DataModel)= db?.getDataDao()?.dataInsert(dataModel)
     fun getData() = db?.getDataDao()?.getAllData()
    suspend fun delete(dataModel: DataModel) = db?.getDataDao()?.deleteData(dataModel)
    suspend fun update(dataModel: DataModel) = db?.getDataDao()?.updateData(dataModel)

}