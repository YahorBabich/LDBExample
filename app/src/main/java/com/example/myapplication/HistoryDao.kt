package com.example.myapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Query("SELECT * FROM history WHERE uid IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<History>

    @Query("SELECT * FROM history WHERE value LIKE :value LIMIT 1")
    fun findByValue(value: String): History

    @Insert
    fun insertAll(vararg histories: History)

    @Delete
    fun delete(history: History)
}