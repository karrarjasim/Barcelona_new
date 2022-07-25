package com.example.barcelona_news.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.barcelona_news.R
import com.example.barcelona_news.data.domain.Category
import com.example.barcelona_news.data.domain.HomeItem
import com.example.barcelona_news.data.domain.Post
import com.example.barcelona_news.data.domain.emuns.HomeItemType
import com.example.barcelona_news.databinding.*
import java.lang.Exception

class HomeAdapter(private val items: List<HomeItem<Any>>): RecyclerView.Adapter<HomeAdapter.BaseHomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        Log.v("view",viewType.toString())
        return when(viewType){
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.header_image, parent, false)
                HeaderViewHolder(view)
            }
            VIEW_TYPE_CATEGORY -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category_list, parent, false)
                CategoryViewHolder(view)
            }
            VIEW_TYPE_POST -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
                PostViewHolder(view)
            }

            VIEW_TYPE_TITLE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.title_item, parent, false)
                TitleViewHolder(view)
            }
            else -> throw Exception("fsdfsdfs")
        }


    }

    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        when(holder){
            is HeaderViewHolder -> bindHeader(holder, position)
            is CategoryViewHolder -> bindCategories(holder, position)
            is PostViewHolder -> bindPosts(holder, position)
            is TitleViewHolder -> bindTitle(holder, position)
        }
    }

    private fun bindTitle(holder: TitleViewHolder, position: Int) {
            val currentTitle = items[position].item as String
            holder.binding.apply {
                titleTextView.text = currentTitle
            }
    }

    private fun bindPosts(holder: PostViewHolder, position: Int) {
        val currentPost = items[position].item as Post
        holder.binding.apply {
            postTitle.text = currentPost.title
            Glide.with(holder.itemView).load(currentPost.image).into(newsImg)
        }

    }

    private fun bindCategories(holder: CategoryViewHolder, position: Int) {
        val categories = items[position].item as List<Category>
        val adapter = CategoryAdapter(categories)
        holder.binding.apply {
            recyclerViewCategory.adapter = adapter
        }
    }

    private fun bindHeader(holder: HeaderViewHolder, position: Int) {
        val url = "https://barcauniversal.com/wp-content/uploads/2021/03/7159537-2048x1365.jpg"
//        holder.binding.apply {
//            Glide.with(holder.itemView).load(url).into(headerImage)
//        }

    }

    override fun getItemCount() = items.size


    abstract class BaseHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class HeaderViewHolder(itemView: View) : BaseHomeViewHolder(itemView){
        val binding = HeaderImageBinding.bind(itemView)
    }

    class CategoryViewHolder(itemView: View) : BaseHomeViewHolder(itemView){
        val binding = ItemCategoryListBinding.bind(itemView)
    }

    class PostViewHolder(itemView: View) : BaseHomeViewHolder(itemView){
        val binding = ItemPostBinding.bind(itemView)
    }

    class TitleViewHolder(itemView: View) : BaseHomeViewHolder(itemView){
        val binding = TitleItemBinding.bind(itemView)
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position].type){
            HomeItemType.TYPE_HEADER -> VIEW_TYPE_HEADER
            HomeItemType.TYPE_CATEGORY -> VIEW_TYPE_CATEGORY
            HomeItemType.TYPE_POST -> VIEW_TYPE_POST
            HomeItemType.TYPE_TITLE-> VIEW_TYPE_TITLE
        }
    }

    companion object {
        private const val VIEW_TYPE_HEADER = 1
        private const val VIEW_TYPE_CATEGORY = 2
        private const val VIEW_TYPE_POST= 3
        private const val VIEW_TYPE_TITLE= 4
    }

}