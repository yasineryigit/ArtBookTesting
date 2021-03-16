package com.ossovita.artbooktesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.ossovita.artbooktesting.adapter.ImageRecyclerAdapter
import com.ossovita.artbooktesting.view.ArtFragmentFactory
import com.ossovita.artbooktesting.view.ImageApiFragment
import com.ossovita.artbooktesting.viewmodel.ArtViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ImageApiFragmentTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory:ArtFragmentFactory

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun selectImage(){

        val navController= Mockito.mock(NavController::class.java)
        val selectedImageUrl="www.codessional.com"
        //ERRORval testViewModel = ArtViewModel(FakeArtRepositoryTest())
        launchFragmentInHiltContainer<ImageApiFragment>(
            factory = fragmentFactory
        ){
            Navigation.setViewNavController(requireView(),navController)
            //ERRORviewModel=testViewModel
            //ERRORviewModel=testViewModel
            imageRecyclerAdapter.images= listOf(selectedImageUrl)
        }

        Espresso.onView(withId(R.id.imageRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImageRecyclerAdapter.ImageViewHolder>(0,click())
        )

        Mockito.verify(navController).popBackStack()
        //ERRORassertThat(testViewModel.selectedImageUrl.getOrAwaitValue()).isEqualTo(selectedImageUrl)
    }
}