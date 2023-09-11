package com.example.practice_data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_data.databinding.RvItemBinding
import java.text.Bidi


class RVAdapter(private val itemList: MutableList<ItemData>) :
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)//view는 클릭된 뷰,position은 아이템의 위치
    }

    var itemClick: ItemClick? = null//기본값은 널

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {

        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false) //리싸이클러뷰의 아이템을 인플레이트 하여 가져옴

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {//데이터를 아이템뷰애 표시하는 데이터전송해서 아이템뷰에 표시
        holder.bindItems(itemList[position])
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)//클릭이벤트가 발생하면 itemclick의 인터페이스이 onclick함수를 호출해서 해당아이템의 위치왑 뷰를 전달
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindItems(item: ItemData) {
            binding.nameArea.text = item.name
            binding.desArea.text = item.description
            binding.phoneArea.text = item.phone
            binding.imgArea.setImageResource(item.photo)

            if (item.isHeart) {
                binding.likeBtn.setImageResource(R.drawable.baseline_favorite_24)
            } else {
                binding.likeBtn.setImageResource(R.drawable.baseline_favorite_border_24)
            }
            binding.likeBtn.setOnClickListener {
                item.isHeart = !item.isHeart
                if (item.isHeart) {
                    binding.likeBtn.setImageResource(R.drawable.baseline_favorite_24)
                } else {
                    binding.likeBtn.setImageResource(R.drawable.baseline_favorite_border_24)
                }
            }
        }
    }

}
