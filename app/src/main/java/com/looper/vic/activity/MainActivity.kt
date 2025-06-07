package com.looper.vic.activity

import android.os.Bundle
import androidx.navigation.NavController
import com.looper.android.support.activity.DrawerNavigationActivity
import com.looper.vic.R

class MainActivity : DrawerNavigationActivity() {

    private val destinationChangeListener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragment_chat -> {
                    setAppBarLiftOnScroll(R.id.recycler_view_chat)
                }

                R.id.fragment_chats -> {
                    setAppBarLiftOnScroll(R.id.recycler_view_chats)
                }

                R.id.fragment_tools -> {
                    setAppBarLiftOnScroll(R.id.recycler_view_tools)
                }

                R.id.fragment_settings -> {
                    setAppBarLiftOnScroll(androidx.preference.R.id.recycler_view)
                }

                R.id.fragment_about -> {
                    setAppBarLiftOnScroll(R.id.about_scroll_view)
                }

                R.id.fragment_select_text -> {
                    setAppBarLiftOnScroll(R.id.select_text_scroll_view)
                }

                R.id.fragment_voice_assistant -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }

                else -> {
                    setAppBarLiftOnScroll(android.R.id.content)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup navigation.
        setupNavigation(R.navigation.mobile_navigation, R.menu.activity_main_drawer)
    }

    override fun onStart() {
        super.onStart()
        navController.addOnDestinationChangedListener(destinationChangeListener)
    }

    override fun onStop() {
        super.onStop()
        navController.removeOnDestinationChangedListener(destinationChangeListener)
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }
}