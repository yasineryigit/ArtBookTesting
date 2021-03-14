package com.ossovita.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.ossovita.artbooktesting.model.Art
import com.ossovita.artbooktesting.model.ImageResponse
import com.ossovita.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt():LiveData<List<Art>>

    suspend fun searchImage(ImageString:String): Resource<ImageResponse>

}