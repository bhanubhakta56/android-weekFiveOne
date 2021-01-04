package com.vanuvakta.weekfiveassignmentone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vanuvakta.weekfiveassignmentone.Users.Post
import com.vanuvakta.weekfiveassignmentone.Users.Users
import com.vanuvakta.weekfiveassignmentone.adapter.PostAdapter
import com.vanuvakta.weekfiveassignmentone.adapter.UserAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var userList = ArrayList<Users>()
    private var postList = ArrayList<Post>()
    private lateinit var stories:RecyclerView
    private lateinit var feed:RecyclerView
    private lateinit var addPost:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stories = findViewById(R.id.stories)
        feed = findViewById(R.id.feed)
        addPost = findViewById(R.id.addPost)
        addPost.setOnClickListener(this)
        loadUser()
        loadPost()
        val storyAdapter = UserAdapter(userList, this)
        val feetAdapter = PostAdapter(postList, this)
        val mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        stories.layoutManager = mLayoutManager
        feed.layoutManager = LinearLayoutManager(this)
        feed.adapter=feetAdapter
        stories.adapter = storyAdapter
    }
    private fun loadUser(){
        userList.add(Users(1, "kiran", "rana", "kiran", "password", "24B"))
        userList.add(Users(2, "rabi", "rana", "rabi", "password", "24B"))
        userList.add(Users(3, "kabi", "rana", "kabi", "password", "24B"))
        userList.add(Users(4, "sabin", "rana", "sabin", "password", "24B"))
        userList.add(Users(1, "kiran", "rana", "kiran", "password", "24B"))
        userList.add(Users(2, "rabi", "rana", "rabi", "password", "24B"))
        userList.add(Users(3, "kabi", "rana", "kabi", "password", "24B"))
        userList.add(Users(4, "sabin", "rana", "sabin", "password", "24B"))
        userList.add(Users(1, "kiran", "rana", "kiran", "password", "24B"))
        userList.add(Users(2, "rabi", "rana", "rabi", "password", "24B"))
        userList.add(Users(3, "kabi", "rana", "kabi", "password", "24B"))
        userList.add(Users(4, "sabin", "rana", "sabin", "password", "24B"))
        userList.add(Users(1, "kiran", "rana", "kiran", "password", "24B"))
        userList.add(Users(2, "rabi", "rana", "rabi", "password", "24B"))
        userList.add(Users(3, "kabi", "rana", "kabi", "password", "24B"))
        userList.add(Users(4, "sabin", "rana", "sabin", "password", "24B"))
        userList.add(Users(1, "kiran", "rana", "kiran", "password", "24B"))
        userList.add(Users(2, "rabi", "rana", "rabi", "password", "24B"))
        userList.add(Users(3, "kabi", "rana", "kabi", "password", "24B"))
        userList.add(Users(4, "sabin", "rana", "sabin", "password", "24B"))
    }
    private fun loadPost(){
        postList.add(Post("sabin", "this is my status.", "link"))
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.addPost->{

            }
        }
    }
}