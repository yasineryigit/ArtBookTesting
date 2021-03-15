package com.ossovita.artbooktesting.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.ossovita.artbooktesting.MainCoroutineRule
import com.ossovita.artbooktesting.getOrAwaitValueTest
import com.ossovita.artbooktesting.repo.FakeArtRepository
import com.ossovita.artbooktesting.util.Status
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewModelTest {

    @get:Rule
    var instantTestExecutorRule=InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ArtViewModel

    @Before
    fun setup(){
        viewModel = ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year returns error`(){//backticks içine ne yapacağımızı ve bunun karşılığında ne beklediğimizi yazıyoruz //year vermeden çalıştıracağız bakalım hatalı mı
        viewModel.makeArt("Mona Lisa","Da vinci","")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without name returns error`(){//name vermeden çalıştıracağız bakalım çalışacak mı
        viewModel.makeArt("","Da vinci","1000")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without artistName returns error`(){//artistName vermeden çalıştıracağız bakalım çalışacak m
        viewModel.makeArt("Mona Lisa","","")
        val value = viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }

}