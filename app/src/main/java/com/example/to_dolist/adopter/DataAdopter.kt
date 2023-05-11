package com.example.to_dolist.adopter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.to_dolist.datamodel.DataModel
import com.example.to_dolist.interfaces.TodoInterface
import com.example.to_dolist.databinding.TodoLayoutBinding

class DataAdopter(var context: Context, val data: ArrayList<DataModel>, var onClick: TodoInterface): RecyclerView.Adapter<DataAdopter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = TodoLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = data[position]
        holder.binding.txtTitle.text = data.Title.toString()
        holder.binding.txtEvent.text = data.Detail.toString()
        holder.binding.CardView.setOnClickListener {
            onClick.onClick(data)
        }
    }
    class MyViewHolder(var binding: TodoLayoutBinding): RecyclerView.ViewHolder(binding.root){

    }
}
