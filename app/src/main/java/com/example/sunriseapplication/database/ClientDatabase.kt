package com.example.sunriseapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sunriseapplication.database.dao.ClientDao
import com.example.sunriseapplication.database.model.DataClient


@Database(entities = [DataClient::class], version = 1)
abstract class ClientDatabase : RoomDatabase() {
    abstract fun userDao(): ClientDao

    companion object {
        @Volatile
        private var instance :ClientDatabase ?=null
        fun getInstance(context: Context): ClientDatabase {
            val temp =instance
            if(temp!=null){
                return temp
            }
            synchronized(this){
                val inst =Room.databaseBuilder(
                    context.applicationContext,
                    ClientDatabase::class.java,
                    "client_database"
                ).build()
                instance=inst
                return instance as ClientDatabase
            }
        }
    }
}