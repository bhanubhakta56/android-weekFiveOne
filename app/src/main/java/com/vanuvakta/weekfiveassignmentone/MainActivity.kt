package com.vanuvakta.weekfiveassignmentone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vanuvakta.weekfiveassignmentone.Users.Post
import com.vanuvakta.weekfiveassignmentone.Users.Users
import com.vanuvakta.weekfiveassignmentone.adapter.PostAdapter
import com.vanuvakta.weekfiveassignmentone.adapter.UserAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var userList = arrayListOf<Users>()
    private var postList = ArrayList<Post>()
    private lateinit var stories:RecyclerView
    private lateinit var feed:RecyclerView
    private lateinit var addPost:FloatingActionButton
    private lateinit var search:EditText
    private lateinit var currentUser:String
    private lateinit var profile:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stories = findViewById(R.id.stories)
        feed = findViewById(R.id.feed)
        addPost = findViewById(R.id.addPost)
        search = findViewById(R.id.search)

        addPost.setOnClickListener(this)
        loadPost()
        val intent = intent
        currentUser = intent.getStringExtra("currentUser").toString()
        userList = intent.getParcelableArrayListExtra<Users>("userList") as ArrayList<Users>
        loadUser()
        profile = intent.getStringExtra("profile").toString()
        val storyAdapter = UserAdapter(userList, this)
        //val stotyAdapter = StoryAdapter(storyList, this)
        val feetAdapter = PostAdapter(postList, this)
        val mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        stories.layoutManager = mLayoutManager
        feed.layoutManager = LinearLayoutManager(this)
        feed.adapter=feetAdapter
        stories.adapter = storyAdapter
    }
    private fun loadUser(){
        userList.add(Users(10250123, "bhanubhakta", "bhandari", "bhanubhakta123", "password", "24B"))
        userList.add(Users(10250124, "sabin", "chapagain", "sabin123", "password", "24B"))
        userList.add(Users(10250125, "ramesh", "bhandari", "ramesh123", "password", "25A"))
        userList.add(Users(10250126, "unish", "bhattarai", "unish123", "password", "24B"))
        userList.add(Users(10250127, "Anish", "Nepal", "anish123", "password", "24B"))
        userList.add(Users(10250127, "Saurav", "Parajuli", "saurav123", "password", "24B"))
        userList.add(Users(10250128, "Roman", "Dulal", "roman123", "password", "24B"))
    }
    private fun loadPost(){
        postList.add(Post("sabin", "https://pbs.twimg.com/media/Bw6VkhPIEAAEXU-?format=jpg&name=small", "Happy Birthday Bro", "https://pbs.twimg.com/media/Bw6VkhPIEAAEXU-?format=jpg&name=small"))
        postList.add(Post("bhanubhakta", "","This is My status", ""))
        postList.add(Post("ramesh","", "This is My status",""))
        postList.add(Post("Anish", "","This is My status",""))
        postList.add(Post("sabin", "","This is my status",""))
        postList.add(Post("saurav", "","This is My status",""))
        postList.add(Post("sabin", "","This is My status",""))
        postList.add(Post("Roman", "","This is My status",""))
        postList.add(Post("Unish", "","This is My status",""))
        postList.add(Post("sabin", "","This is My status",""))
        postList.add(Post("bhanubhakta", "","This is My status",""))
    }

//    private fun loadStories(){
//
//    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.addPost->{
                val intent = Intent(this, PostActivity::class.java)
                startActivityForResult(intent, 1)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                val status = data?.getStringExtra("status").toString()
//                val link = data?.getStringExtra("link").toString()
                postList.add(Post(currentUser,status))
            }
        }
    }
}