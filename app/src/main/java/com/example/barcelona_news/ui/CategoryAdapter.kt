package com.example.barcelona_news.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.barcelona_news.R
import com.example.barcelona_news.data.domain.Category
import com.example.barcelona_news.databinding.ItemCategoryBinding

class CategoryAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.binding.apply {
            teamName.text = categories[position].title
            Glide.with(holder.itemView).load(categories[position].image).into(sportIcon)
        }
    }

    override fun getItemCount() = categories.size

    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemCategoryBinding.bind(itemView)
    }



}