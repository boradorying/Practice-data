package com.example.practice_data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice_data.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemData = intent.getParcelableExtra<ItemData>("item")

        itemData?.let {
            binding.nameArea.text = itemData.name
            binding.phoneArea.text = itemData.phone
            binding.desArea.text = itemData.description
            binding.imgArea.setImageResource(itemData.photo)

            if (itemData.isHeart ){
                binding.likeBtn.setImageResource(R.drawable.baseline_favorite_24)
            }else{
                binding.likeBtn.setImageResource(R.drawable.baseline_favorite_border_24)
            }
        }





    }
}