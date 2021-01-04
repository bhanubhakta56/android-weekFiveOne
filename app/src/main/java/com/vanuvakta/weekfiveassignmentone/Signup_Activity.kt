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
import org.w3c.dom.Text

class Signup_Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnRegister:Button

    private lateinit var etCoventryID:EditText
    private lateinit var etFname:EditText
    private lateinit var etLname:EditText
    private lateinit var etUsername:EditText
    private lateinit var etPassword:EditText
    private lateinit var etBatch:EditText
    private lateinit var loginLink:TextView
    private var userList = arrayListOf<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_)
        btnRegister = findViewById(R.id.btnRegister)
        etCoventryID = findViewById(R.id.etCoventryID)
        etFname = findViewById(R.id.etFname)
        etLname = findViewById(R.id.etLname)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etBatch = findViewById(R.id.etBatch)
        loginLink = findViewById(R.id.loginLink)
        btnRegister.setOnClickListener(this)
        loginLink.setOnClickListener(this)
        loadUser()
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnRegister ->{
                val user = Users(etCoventryID.text.toString().toInt(), etFname.text.toString(), etLname.text.toString(),etUsername.text.toString(), etPassword.text.toString(), etBatch.text.toString())
                var intent = Intent();
                intent.putExtra("user",user);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
            R.id.loginLink->{
                Companion.loadLogin(this)
            }
        }
    }
    fun loadUser(){
        userList.add(Users(10250123, "bhanubhakta", "bhandari", "bhanubhakta123", "password", "24B"))
        userList.add(Users(10250124, "sabin", "chapagain", "sabin123", "password", "24B"))
        userList.add(Users(10250125, "ramesh", "bhandari", "ramesh123", "password", "25A"))
        userList.add(Users(10250126, "unish", "bhattarai", "unish123", "password", "24B"))
        userList.add(Users(10250127, "Anish", "Nepal", "anish123", "password", "24B"))
        userList.add(Users(10250127, "Saurav", "Parajuli", "saurav123", "password", "24B"))
        userList.add(Users(10250128, "Roman", "Dulal", "roman123", "password", "24B"))
    }

    companion object {
        fun loadLogin(activity: Signup_Activity){
            val intent = Intent(activity, LoginActivity::class.java)
            intent.putExtra("userlist", activity.userList)
            activity.startActivity(intent)
        }
    }
}