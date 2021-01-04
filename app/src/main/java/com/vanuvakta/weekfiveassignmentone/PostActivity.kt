package com.vanuvakta.weekfiveassignmentone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PostActivity : AppCompatActivity() {
    private lateinit var tvStatus:EditText
    private lateinit var tvLink:EditText
    private lateinit var btnPost: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        tvStatus=findViewById(R.id.tvStatus)
        tvLink=findViewById(R.id.tvLink)
        btnPost=findViewById(R.id.btnPost)
    }
}