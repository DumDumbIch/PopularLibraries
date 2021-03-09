package com.dumdumbich.popularlibraries.lesson_2.navigation

import com.dumdumbich.popularlibraries.lesson_2.ui.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}