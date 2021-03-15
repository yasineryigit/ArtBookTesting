package com.ossovita.artbooktesting.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ossovita.artbooktesting.model.Art

@Dao
interface ArtDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)// aynı id'den veriler yazarken conflict durumunda yer değiştir diyoruz
    suspend fun insertArt(arts:Art)

    @Delete
    suspend fun deleteArt(art:Art)

    @Query("SELECT * FROM arts")
    fun observeArts(): LiveData<List<Art>> //LiveData zaten asenkron çalıştığı için başına suspend yazmadık


    @Query("SELECT * FROM arts")
    suspend fun getAllArts():List<Art> //Tüm arts objelerini getirecek, Art listesi şeklinde döndürecek


    /* These functions can be used, but no needed.
    @Query("SELECT * FROM arts WHERE id==artId")
    suspend fun getArt(artId:Int):Art

    @Query("DELETE FROM arts")
    suspend fun deleteAllArts()
    */

}