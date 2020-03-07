package com.example.martiantimes.database

import android.content.Context
import androidx.room.*
import com.example.martiantimes.model.ConverterClass
import com.example.martiantimes.model.MartianResponse

//@Database(entities = arrayOf(MartianResponse::class), version = 1, exportSchema = false)
//@TypeConverters(ConverterClass::class)
//abstract class MartianDataBase : RoomDatabase() {
//    abstract fun martianDao(): MartianDao
//
//    companion object {
//        @Volatile
//        private var instance: MartianDataBase? = null
//        private val Lock = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
//            instance ?: buildDataBase(context).also {
//                instance = it
//            }
//
//        }
//
//        private fun buildDataBase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            MartianDataBase::class.java,
//            "martiandatabase"
//        ).build()
//    }
//
//}