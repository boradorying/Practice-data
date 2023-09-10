package com.example.practice_data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_data.databinding.RvItemBinding
import java.text.Bidi


class RVAdapter(private val itemList:MutableList<ItemData>):RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    interface ItemClick{
       fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {

        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItems(itemList[position])
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }
    }
    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class ViewHolder(private val binding : RvItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItems(item : ItemData){
            binding.nameArea.text = item.name
            binding.desArea.text = item.description
            binding.phoneArea.text = item.phone
            binding.imgArea.setImageResource(item.photo)
            if (item.isHeart){
                binding.likeBtn.setImageResource(R.drawable.baseline_favorite_24)
            }else{binding.likeBtn.setImageResource(R.drawable.baseline_favorite_border_24)
        }
    }
}}