package com.ossovita.artbooktesting.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ossovita.artbooktesting.model.Art

@Database(entities = [Art::class],version=1)
abstract class ArtDatabase : RoomDatabase(){
    abstract fun artDao():ArtDao //Bu classı kullanan sınıflar bu ArtDao döndüren constructorı barındırmak zorundadır

}