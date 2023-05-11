package com.example.to_dolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.to_dolist.repositories.todo_repository
import com.example.to_dolist.ui.todoViewModel

class viewModalFactory(private var todoRepository: todo_repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return todoViewModel(todoRepository) as T
    }
}