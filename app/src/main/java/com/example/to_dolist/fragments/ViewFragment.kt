package com.example.to_dolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_dolist.adopter.DataAdopter
import com.example.to_dolist.datamodel.DataModel
import com.example.to_dolist.R
import com.example.to_dolist.interfaces.TodoInterface
import com.example.to_dolist.databinding.FragmentViewBinding
import com.example.to_dolist.db.AppDatabase
import com.example.to_dolist.repositories.todo_repository
import com.example.to_dolist.ui.todoViewModel
import com.example.to_dolist.viewModalFactory
import kotlinx.coroutines.*

class ViewFragment : Fragment(), TodoInterface {
    private var binding: FragmentViewBinding? = null
    private var recyclerView: RecyclerView? = null
    private var database: AppDatabase? = null
    private var viewModel: todoViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentViewBinding.inflate(LayoutInflater.from(context), container, false)

        recyclerView = binding?.recyclerView
        recyclerView?.layoutManager = LinearLayoutManager(context)
        var adopter = recyclerView?.adapter

        database = AppDatabase(requireContext())
        val data =  database?.getDataDao()?.getAllData()
        recyclerView?.adapter = DataAdopter(requireContext(), data,this@ViewFragment)
        //checkRecyclerView()

        val todoRepository = todo_repository()
        val factory = viewModalFactory(todoRepository)

        viewModel = ViewModelProvider(this, factory).get(todoViewModel::class.java)


        viewModel?.getAlldata()?.observe(viewLifecycleOwner, Observer {

        })

/*        binding?.btnAdd?.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }*/


        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onClick(dataModel: DataModel) {
        TODO("Not yet implemented")
    }

/*    private fun checkRecyclerView() {
        readData()
    }


    @SuppressLint("SuspiciousIndentation")
    private fun readData(){
        GlobalScope.launch {
          val data =  database?.getDataDao()?.getAllData()
            showOnRecyclerView(data)
        }
    }

    private suspend fun showOnRecyclerView(data: LiveData<List<DataModel>>?) {
        withContext(Dispatchers.Main){
            if (data != null) {
                recyclerView?.adapter = DataAdopter(requireContext(), data,this@ViewFragment )
            }
            else{
                Toast.makeText(requireContext(),"null",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override  fun onClick(dataModel: DataModel) {
        val bundle =Bundle()
        bundle.putString("title",dataModel.Title)
        bundle.putString("detail",dataModel.Detail)
        bundle.putString("id",dataModel.Id.toString())
        findNavController().navigate(R.id.editFragment,bundle)
    }*/
}