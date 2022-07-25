package com.example.barcelona_news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.barcelona_news.data.DataManager
import com.example.barcelona_news.data.domain.HomeItem
import com.example.barcelona_news.data.domain.emuns.HomeItemType
import com.example.barcelona_news.databinding.ActivityMainBinding
import com.example.barcelona_news.util.toHomeItem


class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    val dataManager = DataManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        val itemsList: MutableList<HomeItem<Any>> = mutableListOf()
        itemsList.add(HomeItem("Last Match",HomeItemType.TYPE_HEADER))
        itemsList.add(HomeItem("Categories", HomeItemType.TYPE_TITLE))
        itemsList.add(HomeItem(DataManager.getCategories(),HomeItemType.TYPE_CATEGORY))
        itemsList.add(HomeItem("Latest News", HomeItemType.TYPE_TITLE))
        itemsList.addAll(
            DataManager.getPosts().map {
                it.toHomeItem()
            }
        )
        val adapter = HomeAdapter(itemsList)
        binding.recyclerViewHome.adapter = adapter
    }


}