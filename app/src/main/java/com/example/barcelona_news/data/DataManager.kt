package com.example.barcelona_news.data

import com.example.barcelona_news.data.domain.Category
import com.example.barcelona_news.data.domain.Post

object DataManager {
    fun getCategories() : List<Category> = listOf(
        Category("Football", "https://cdn.icon-icons.com/icons2/553/PNG/512/footbal_icon-icons.com_53569.png"),
        Category("Basketball", "https://cdn.icon-icons.com/icons2/553/PNG/512/basketball_icon-icons.com_53566.png"),
        Category("Tennis", "https://cdn.icon-icons.com/icons2/553/PNG/512/tennis_icon-icons.com_53563.png"),
        Category("Volleyball", "https://cdn.icon-icons.com/icons2/553/PNG/512/volleyball_icon-icons.com_53568.png"),
        Category("Golf", "https://cdn.icon-icons.com/icons2/553/PNG/512/golf_icon-icons.com_53570.png"),
        Category("Baseball", "https://cdn.icon-icons.com/icons2/553/PNG/512/baseball_icon-icons.com_53567.png"),
    )

    fun getPosts(): List<Post> = listOf(
        Post("Barcelona president hints at a possible Lionel Messi return", "https://barcauniversal.com/wp-content/uploads/2022/07/paris-saint-germain-v-kawasaki-frontale-preseason-friendly-2048x1365.jpg","1/1/2020"),
        Post("Barcelona slap €20 million asking price on exit-linked striker", "https://barcauniversal.com/wp-content/uploads/2022/07/fc-barcelona-v-inter-miami-cf-pre-season-friendly-2-1-2048x1365.jpg","1/1/2020"),
        Post("We have a winning mentality even in training", "https://barcauniversal.com/wp-content/uploads/2022/07/fc-barcelona-v-inter-miami-cf-pre-season-friendly-4-2048x1365.jpg","1/1/2020"),
        Post("16-year-old Barcelona prospect set to join Bayern Munich", "https://barcauniversal.com/wp-content/uploads/2022/07/fc-bayern-women-v-vfl-wolfsburg-women-flyeralarm-frauen-bundesliga-2048x1365.jpg","1/1/2020"),
    )
}