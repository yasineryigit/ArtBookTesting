package com.ossovita.artbooktesting.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arts")//CREATE TABLE IF NOT EXISTS der gibi
data class Art (
    var name:String,
    var artistName:String,
    var year: Int,
    var imageUrl: String,

    @PrimaryKey(autoGenerate = true)//Buradaki id integerının primary key olacağını söylüyoruz
    var id: Int?=null
)