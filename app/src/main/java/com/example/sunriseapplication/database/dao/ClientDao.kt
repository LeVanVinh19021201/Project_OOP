package com.example.sunriseapplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunriseapplication.database.model.DataClient

@Dao
interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insetClient(data: DataClient)

    @Query("SELECT * FROM client_database ORDER BY id ASC")
    fun getAllDdata(): LiveData<List<DataClient>>
}