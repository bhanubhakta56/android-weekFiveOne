package com.vanuvakta.weekfiveassignmentone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vanuvakta.weekfiveassignmentone.R
import com.vanuvakta.weekfiveassignmentone.Users.Post

class PostAdapter(
    val postList:ArrayList<Post>,
    val context: Context
) :RecyclerView.Adapter<PostAdapter.PostViewHolder>()  {
    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvUser: TextView
        val imgPost: ImageView
        val tvStatus: TextView
        init {
            imgPost = view.findViewById(R.id.imgPost)
            tvUser = view.findViewById(R.id.tvUser)
            tvStatus = view.findViewById(R.id.tvStatus)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
//        var size = 0
//        var a = postList.size
//        for (i in a downTo 0){
//            size = i
//        }
//        return size
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.imgPost.setImageResource(R.drawable.i)
        holder.tvUser.text=post.user
        holder.tvStatus.text=post.status
    }
}