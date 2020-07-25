package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val db = MyApplication.db

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save.setOnClickListener {
            val users = mutableListOf<History>()
            users.add(History("value1"))
            users.add(History("value2"))
            users.add(History("value3"))
            db?.historyDao()?.insertAll(*users.toTypedArray())
        }

        get.setOnClickListener {
            val users = db?.historyDao()?.getAll()
            Toast.makeText(this, users.toString(), Toast.LENGTH_LONG).show()
        }
    }
}