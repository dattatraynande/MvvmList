package com.virgo.mvvmlist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.virgo.mvvmlist.databinding.RowListBinding
import com.virgo.mvvmlist.model.User

class MainAdapter(private var userList: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return userList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = userList.get(position)
        holder.binding.name.text = user.name
        holder.binding.email.text = user.email
        Glide.with(holder.itemView.context)
            .load(user.image)
            .into(holder.binding.image)
    }

    inner class MyViewHolder(val binding: RowListBinding) : RecyclerView.ViewHolder(binding.root)

}