package com.ossovita.artbooktesting.repo

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ossovita.artbooktesting.model.Art
import com.ossovita.artbooktesting.model.ImageResponse
import com.ossovita.artbooktesting.util.Resource

class FakeArtRepository : ArtRepositoryInterface {

    private val arts =  mutableListOf<Art>()
    private val artsLiveData = MutableLiveData<List<Art>>()

    override suspend fun insertArt(art: Art) {
        arts.add(art)
        refreshData()
    }

    override suspend fun deleteArt(art: Art) {
        arts.remove(art)
        refreshData()
    }

    override fun getArt(): LiveData<List<Art>> {
        return artsLiveData
    }

    override suspend fun searchImage(ImageString: String): Resource<ImageResponse> {
        return Resource.success(ImageResponse(listOf(),0,0))
    }

    private fun refreshData(){
        artsLiveData.postValue(arts)
    }
}