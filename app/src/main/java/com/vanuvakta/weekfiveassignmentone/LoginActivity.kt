package com.vanuvakta.weekfiveassignmentone

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.vanuvakta.weekfiveassignmentone.Users.Users

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private var userList=ArrayList<Users>()
    private lateinit var btnLogin:Button
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var signupLink:TextView
    private lateinit var invalid:TextView
    private lateinit var username:String
    private lateinit var password:String
    val MIN_PASSWORD_LENGTH = 6
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loadUser()
        btnLogin=findViewById(R.id.btnLogin)
        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        signupLink=findViewById(R.id.signupLink)
        invalid=findViewById(R.id.invalid)
        signupLink.setOnClickListener(this)
        btnLogin.setOnClickListener(this)

        //etUsername.append("${userList.get((userList.size-1)).username}")

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLogin->{
                if (loginAuthorization()){
                    Toast.makeText(this, "Login Sucessfull", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    invalid.text ="**Invalid Username or Password**"
                }
//                for (i in userList.indices){
//                    if (etUsername.text.toString()==userList.get(i).username && etPassword.text.toString()==userList.get(i).password){
//                        Toast.makeText(this, "Login Sucessfull", Toast.LENGTH_SHORT).show()
//                        val intent=Intent(this, MainActivity::class.java)
//                        startActivity(intent)
//                    }
//                    else{
//                        Toast.makeText(this, "Ivalid Login", Toast.LENGTH_SHORT).show()
//                    }
//                }
            }
            R.id.signupLink->{
                val intent = Intent(this, Signup_Activity::class.java)
                startActivityForResult(intent, 1)
            }
        }
    }
    private fun loginAuthorization():Boolean{
        username = etUsername.text.toString()
        password = etPassword.text.toString()
        if(validateInput()){
            for (i in userList.indices){
//                etUsername.append("${userList.get(i).username}")
//                etPassword.setText("${userList.get(i).password}")
                val user = userList.get(i).username
                val pass = userList.get(i).password
                if (username==user && password==pass){
                    return true
                }
            }
        }
        return false
    }
    fun validateInput(): Boolean {
        if (etUsername.text.toString() == "") {
            etUsername.error = "Please Enter Username"
            return false
        }
        if (etPassword.text.toString() == "") {
            if (etUsername.text.toString() == "") {
                etUsername.error = "Please Enter Username"
                return false
            }
            etPassword.error = "Please Enter Password"
            return false
        }

        // checking the proper email format


        // checking minimum password Length
        if (etPassword.text.length < MIN_PASSWORD_LENGTH) {
            etPassword.error = "Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters"
            return false
        }
        return true
    }
    private fun loadUser(){
        val intent = intent
        userList = intent.getParcelableArrayListExtra<Users>("userlist") as ArrayList<Users>
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                val user = data?.getParcelableExtra<Users>("user")
                userList.add(user!!)
            }
        }
    }
}