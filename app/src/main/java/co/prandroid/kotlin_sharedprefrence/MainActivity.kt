package co.prandroid.kotlin_sharedprefrence

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var shredPref:SharedPreferences?=null
    var editor:SharedPreferences.Editor?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        shredPref=getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)
        editor=shredPref!!.edit()


        editTextUsername.setText(shredPref!!.getString(NAME,""))
        editTextPassword.setText(shredPref!!.getString(PASSWORD,""))


    }

    fun btnSave(view: View){
        var name:String=editTextUsername.text.toString()
        var password:String=editTextPassword.text.toString()

        var intent=Intent(applicationContext, SecondActivity::class.java)
        editor!!.putString(NAME,name)
        editor!!.putString(PASSWORD,password)
        editor!!.apply()
        startActivity(intent)
    }

    companion object {
        val MY_PREF="my_pref"
        var NAME="name"
        var PASSWORD="password"
    }
}
