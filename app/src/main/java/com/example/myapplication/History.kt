package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(@ColumnInfo(name = "value") val value: String) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}