package com.example.martiantimes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.martiantimes.model.MartianResponse

//@Dao
//interface MartianDao {
//
//    @Insert
//    suspend fun insertAll(vararg martians: MartianResponse): List<Long>
//
//    @Query("SELECT * FROM martianresponse")
//    suspend fun getAllMartians(): List<MartianResponse>
//
//    @Query("SELECT * FROM martianresponse WHERE uuid = :martianId ")
//    suspend fun getMartian(martianId: Int): MartianResponse
//
//    @Query("DELETE FROM martianResponse")
//    suspend fun deleteAllMartians()
//
//
//
//}