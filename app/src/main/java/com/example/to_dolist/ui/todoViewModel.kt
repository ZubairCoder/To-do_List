package com.example.to_dolist.ui

import androidx.lifecycle.ViewModel
import com.example.to_dolist.datamodel.DataModel
import com.example.to_dolist.repositories.todo_repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class todoViewModel(
    private val repository : todo_repository? = null): ViewModel() {
        fun insert(dataModel : DataModel)= CoroutineScope(Dispatchers.IO).launch {
            repository?.insert(dataModel)
        }
    fun delete(dataModel: DataModel)= CoroutineScope(Dispatchers.IO).launch {
        repository?.delete(dataModel)
    }
    fun getAlldata()= repository?.getData()
    }