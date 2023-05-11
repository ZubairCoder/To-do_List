package com.example.to_dolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_dolist.databinding.ActivityMainBinding
import com.example.to_dolist.db.AppDatabase
import com.example.to_dolist.repositories.todo_repository
import com.example.to_dolist.viewModalFactory


class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    private var viewModel : todoViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Recycler.....




        setContentView(binding?.root)
    }
}