package com.example.sunriseapplication.presentation.repository

import androidx.lifecycle.LiveData
import com.example.sunriseapplication.database.dao.ClientDao
import com.example.sunriseapplication.database.model.DataClient

class ClientRepository(private val dao :ClientDao) {
    val getAllData :LiveData<List<DataClient>> =dao.getAllDdata()

    suspend fun insertData(data :DataClient){
        dao.insetClient(data)
    }
}