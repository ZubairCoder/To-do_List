package com.example.to_dolist.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.to_dolist.datamodel.DataModel
import com.example.to_dolist.R
import com.example.to_dolist.databinding.FragmentAddBinding
import com.example.to_dolist.db.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AddFragment : Fragment() {
    private var binding: FragmentAddBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddBinding.inflate(LayoutInflater.from(context), container, false)
        binding?.btnAddData?.setOnClickListener {
            if (binding?.txtAddTitle?.text!!.isNotEmpty() && binding?.txtAddDetail?.text!!.isNotEmpty()) {
                insertData()
                Toast.makeText(context, "Data Inserted", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.viewFragment)
            } else {
                Toast.makeText(context, "Fields are empty", Toast.LENGTH_SHORT).show()

            }
        }


        return binding?.root
    }

    //@SuppressLint("SuspiciousIndentation")
    private fun insertData() {
        val title = binding?.txtAddTitle?.text.toString()
        val detail = binding?.txtAddDetail?.text.toString()

        GlobalScope.launch {
            val dataModel = DataModel(null, title, detail)
            AppDatabase(requireContext()).getDataDao().dataInsert(dataModel)
        }
        binding?.txtAddTitle?.text?.clear()
        binding?.txtAddTitle?.text?.clear()
    }
}