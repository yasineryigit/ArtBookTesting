package com.ossovita.artbooktesting.viewmodel

import com.ossovita.artbooktesting.repo.FakeArtRepository
import org.junit.Before

class ArtViewModelTest {
    private lateinit var viewModel: ArtViewModel

    @Before
    fun setup(){
        viewModel = ArtViewModel(FakeArtRepository())
    }

}