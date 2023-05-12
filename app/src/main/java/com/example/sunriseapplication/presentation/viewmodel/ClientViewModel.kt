package com.example.sunriseapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sunriseapplication.database.ClientDatabase
import com.example.sunriseapplication.database.model.DataClient
import com.example.sunriseapplication.presentation.repository.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(application: Application) : AndroidViewModel(application) {
    private val getAlldata: LiveData<List<DataClient>>
    private val repository: ClientRepository

    init {
        val clientDao = ClientDatabase.getInstance(application).userDao()
        repository = ClientRepository(clientDao)
        getAlldata=repository.getAllData
    }

    fun insertData(data :DataClient){
        viewModelScope.launch {
            repository.insertData(data)
        }
    }
}