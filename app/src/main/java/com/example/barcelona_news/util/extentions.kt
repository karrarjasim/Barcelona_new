package com.example.barcelona_news.util

import com.example.barcelona_news.data.domain.HomeItem
import com.example.barcelona_news.data.domain.Post
import com.example.barcelona_news.data.domain.emuns.HomeItemType

fun Post.toHomeItem(): HomeItem<Any>{
    return HomeItem(this, HomeItemType.TYPE_POST)
}