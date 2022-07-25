package com.example.barcelona_news.data.domain

import com.example.barcelona_news.data.domain.emuns.HomeItemType

data class HomeItem<T>(
    val item: T,
    val type: HomeItemType
)
