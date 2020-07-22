package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        save.setOnClickListener {
            val users = mutableListOf<History>()
            users.add(History(100, "value1"))
            users.add(History(101, "value2"))
            users.add(History(102, "value3"))
            db.historyDao().insertAll(*users.toTypedArray())
        }

        get.setOnClickListener {
            val users = db.historyDao().getAll()
            Toast.makeText(this, users.toString(), Toast.LENGTH_LONG).show()
        }
    }
}