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

        itemData?.also {
            with(binding) {
                nameArea.text = it.name
                phoneArea.text = it.phone
                desArea.text = it.description
                imgArea.setImageResource(it.photo)

                if (it.isHeart) {
                    likeBtn.setImageResource(R.drawable.baseline_favorite_24)
                } else {
                    likeBtn.setImageResource(R.drawable.baseline_favorite_border_24)
                }
            }
        }


        binding.likeBtn.setOnClickListener {
            itemData!!.isHeart = !itemData.isHeart
            if (itemData.isHeart) {
                binding.likeBtn.setImageResource(R.drawable.baseline_favorite_24)
            } else {
                binding.likeBtn.setImageResource(R.drawable.baseline_favorite_border_24)
            }

            val resultIntent = Intent().apply {
                putExtra("item", itemData)//키를 상수로 정의 해두자 휴먼에러 생길 수 있으니 해두자 const val
                          }
            setResult(RESULT_OK, resultIntent)
        }
    }
}