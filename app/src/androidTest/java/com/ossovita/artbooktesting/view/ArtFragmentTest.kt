package com.ossovita.artbooktesting.view

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.ossovita.artbooktesting.R
import com.ossovita.artbooktesting.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
class ArtFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory:ArtFragmentFactory

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun testNavigationFromArtToArtDetails(){

        val navController = Mockito.mock(NavController::class.java)
        launchFragmentInHiltContainer<ArtFragment>(
            factory = fragmentFactory
        ){
            Navigation.setViewNavController(requireView(),navController)
        }

        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewAction.click())

        Mockito.verify(navController).navigate(
            ArtFragmentDirections.actionArtFragmentToArtDetailsFragment()
        )
    }

}