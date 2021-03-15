package com.ossovita.artbooktesting.roomdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import androidx.test.filters.SmallTest;
import com.google.common.truth.Truth.assertThat
import com.ossovita.artbooktesting.model.Art
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@SmallTest
@ExperimentalCoroutinesApi
class ArtDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var database: ArtDatabase
    private lateinit var dao:ArtDao

    @Before
    fun setup(){
        database= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),ArtDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.artDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertArtTesting() = runBlocking{
        //Örnek veri oluşturup database'e ekliyoruz. ve listeye gelen livedataya bu verinin eklendiğini assert ediyoruz
        val exampleArt = Art("Mona Lisa","Da Vinci",1700,"test.com",1)
        dao.insertArt(exampleArt)

        val list = dao.observeArts().getOrAwaitValueTest()
        assertThat(list).contains(exampleArt)
    }

    @Test
    fun deleteArtTesting() = runBlocking{
        //Örnek veri oluşturup database'den siliyoruz. ve listeye gelen livedatada bu verinin artık bulunmadığını assert ediyoruz
        val exampleArt = Art("Mona Lisa","Da Vinci",1700,"test.com",1)
        dao.insertArt(exampleArt)
        dao.deleteArt(exampleArt)
        val list = dao.observeArts().getOrAwaitValueTest()
        assertThat(list).doesNotContain(exampleArt)

    }

}