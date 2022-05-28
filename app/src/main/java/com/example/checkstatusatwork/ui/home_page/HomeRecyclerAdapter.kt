package com.example.checkstatusatwork.ui.home_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.checkstatusatwork.R
import com.example.checkstatusatwork.databinding.UserListItemBinding
import com.example.checkstatusatwork.model.User

class HomeRecyclerAdapter: ListAdapter<User, HomeRecyclerAdapter.ItemHolder>(UserDiffCallback) {

    class ItemHolder(val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding:UserListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_list_item,
            parent,false
        )
        return ItemHolder(binding)
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.binding.name.text = getItem(position).name
        holder.binding.status.text = getItem(position).status
        Glide.with(holder.binding.image)
            .load(getItem(position).avatar)
            .into(holder.binding.image)

    }
}
object UserDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}