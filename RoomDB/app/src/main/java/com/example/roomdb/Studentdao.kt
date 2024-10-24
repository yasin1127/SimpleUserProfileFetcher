package com.example.roomdb

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface Studentdao {
    @Query("SELECT * FROM s_t")
    fun getAll(): List<Student>

    @Query("SELECT * FROM s_t WHERE r_n = :rollNumber")
    suspend fun findByRollNumber(rollNo:Int):Student

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("DELETE FROM s_t")
    suspend fun deleteAll()

    @Query("SELECT (SELECT COUNT(*) FROM s_t)=0")
    fun isEmpty(): Boolean
}