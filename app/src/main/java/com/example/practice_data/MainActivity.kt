package com.example.practice_data

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.practice_data.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val adapter = RVAdapter(ItemManager.ItemList)
        binding.RVArea.adapter = adapter
        binding.RVArea.layoutManager = LinearLayoutManager(this)

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val modifiedItem = result.data!!.getParcelableExtra<ItemData>("item")
                    if (modifiedItem != null){
                       for(i in ItemManager.ItemList.indices){
                           if (ItemManager.ItemList[i].name == modifiedItem.name){
                               ItemManager.ItemList[i] = modifiedItem
                                   adapter.notifyDataSetChanged()
                           }
                       }
                    }

                }
            }


        adapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("item", ItemManager.ItemList[position])

                resultLauncher.launch(intent)
            }
        }


    }
}