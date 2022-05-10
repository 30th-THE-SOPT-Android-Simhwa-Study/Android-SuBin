package org.sopt.androidstudy.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidstudy.databinding.ItemFriendBinding


class FriendRecyclerViewAdapter :
    ListAdapter<Friend, FriendRecyclerViewAdapter.FriendViewHolder>(DIFFUTIL) {

    var friend = mutableListOf<Friend>()

    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = ItemFriendBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.onBind(getItem(position))
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }
    class FriendViewHolder(
        private val binding: ItemFriendBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(friend: Friend) {
            binding.friend = friend
        }
    }

    fun remove(position: Int) {
        val newList = currentList.toMutableList()
        newList.removeAt(position)
        submitList(newList)
    }


    companion object {
        val DIFFUTIL = object : DiffUtil.ItemCallback<Friend>() {
            override fun areItemsTheSame(
                oldItem: Friend,
                newItem: Friend
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Friend,
                newItem: Friend
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(data: View, position: Int)
    }

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

}