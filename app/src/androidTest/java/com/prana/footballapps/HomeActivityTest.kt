package com.prana.footballapps

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.prana.footballapps.R.id.*
import com.prana.footballapps.view.HomeActivity
import kotlinx.android.synthetic.main.fragment_favo_match.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {
    @Rule
    @JvmField var activityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testRecyclerViewPrevMatchBehaviour() {
        Thread.sleep(3000)
        onView(withId(rv_match_list)).check(matches(isDisplayed()))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
    }

    @Test
    fun testRecyclerNextMatchBehaviour() {

        onView(withId(btn_navigation)).check(matches(isDisplayed()))
        onView(withId(nav_next_match)).perform(click())

        Thread.sleep(3000)
        onView(withId(rv_match_list)).check(matches(isDisplayed()))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
    }

    @Test
    fun testFootballAppBehaviour(){

        // Melihat list prev match, scroll ke position 7, dan klik posisi 5
        Thread.sleep(3000)
        onView(withId(rv_match_list)).check(matches(isDisplayed()))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        // Masuk kehalaman detail, klik botton favorite
        Thread.sleep(2000)
        onView(withId(add_to_favorite)).check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())
        Thread.sleep(1500)
        onView(withText("Added to Your Favorite Match")).check(matches(isDisplayed()))
        //onView(withText("Remove From Favorite Match")).check(matches(isDisplayed()))

        // kembali ke homeActivity
        pressBack()

        // Check button navigasi dan click ke fragment next match
        onView(withId(btn_navigation)).check(matches(isDisplayed()))
        onView(withId(nav_next_match)).perform(click())

        // Menunggun 3 detik, Check list next match RecyclerView, scroll ke posisi 5, klik posisi 4
        Thread.sleep(3000)
        onView(withId(rv_match_list)).check(matches(isDisplayed()))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(rv_match_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))

        // Masuk ke halaman detail, klik Botton Favorite
        Thread.sleep(2000)
        onView(withId(add_to_favorite)).check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())
        Thread.sleep(1500)
        onView(withText("Added to Your Favorite Match")).check(matches(isDisplayed()))

        // Kembali ke halaman HomeActivity
        pressBack()

        // Ke Halaman Favorite
        onView(withId(btn_navigation)).check(matches(isDisplayed()))
        onView(withId(nav_fav_match)).perform(click())

        // Masuk halaman Favorite tunggu 2 detik, check list Recyclerview, scroll ke posisi 2, click posisi 1
        Thread.sleep(2000)
        onView(withId(rv_fav_match)).check(matches(isDisplayed()))
        onView(withId(rv_fav_match)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        onView(withId(rv_fav_match)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,click()))

    }
}