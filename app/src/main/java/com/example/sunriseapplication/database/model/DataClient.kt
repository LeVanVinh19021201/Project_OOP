package com.example.sunriseapplication.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "client_database")
data class DataClient(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var dateOfBirth: String = "",
    var date: String = "",
    var numberPhone: String ="",
    var state: Boolean =false,
    var descript: String =""
)