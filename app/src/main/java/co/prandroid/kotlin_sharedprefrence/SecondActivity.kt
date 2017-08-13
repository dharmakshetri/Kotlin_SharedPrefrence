package co.prandroid.kotlin_sharedprefrence

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    var sharedPref:SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sharedPref=getSharedPreferences(MainActivity.MY_PREF, Context.MODE_PRIVATE)

        textViewUserName.text="Username: "+ sharedPref!!.getString(MainActivity.NAME," ")
        textViewPassword.text="Password: "+ sharedPref!!.getString(MainActivity.PASSWORD," ")
    }

    fun  backBtn(view: View){
        var intentBack= Intent(applicationContext, MainActivity::class.java)
        startActivity(intentBack)
    }
}
