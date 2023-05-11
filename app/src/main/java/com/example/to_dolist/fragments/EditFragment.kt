package com.example.to_dolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.to_dolist.datamodel.DataModel
import com.example.to_dolist.databinding.FragmentEditBinding
import com.example.to_dolist.db.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class EditFragment : Fragment() {
    private var binding :FragmentEditBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentEditBinding.inflate(LayoutInflater.from(context),container,false)

        var title = arguments?.getString("title")
        var detail = arguments?.getString("detail")
        var id = arguments?.getString("id")

        binding?.txtAddTitle?.setText(title)
        binding?.txtAddDetail?.setText(detail)

        binding?.btnUpdate?.setOnClickListener {
            update()
/*           GlobalScope.launch {
               val data = AppDatabase(requireContext()).getDataDao().getOneData(id?:return@launch)
               update(data)
           }*/
        }

        // Inflate the layout for this fragment
        return binding?.root
    }

    private fun update() {
        val updatedTitle = binding?.txtAddTitle?.text.toString()
        val updatedDetail = binding?.txtAddDetail?.text.toString()
        GlobalScope.launch {
            val data = DataModel(null,updatedTitle,updatedDetail)
            AppDatabase(requireContext()).getDataDao().updateData(data)
        }
        binding?.txtAddTitle?.text?.clear()
        binding?.txtAddDetail?.text?.clear()
    }

}