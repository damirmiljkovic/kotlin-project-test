package net.alhazmy13.demoproject.ui.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import net.alhazmy13.demoproject.BR
import net.alhazmy13.demoproject.R
import net.alhazmy13.demoproject.model.PostModel


class PostsAdapter(private val posts: List<PostModel>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }


    inner class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostModel) {
            binding.setVariable(BR.post, post)
            binding.executePendingBindings()
        }
    }
}