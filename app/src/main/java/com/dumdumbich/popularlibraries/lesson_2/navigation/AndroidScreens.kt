package com.dumdumbich.popularlibraries.lesson_2.navigation

import com.dumdumbich.popularlibraries.lesson_2.model.entity.GitHubUser
import com.dumdumbich.popularlibraries.lesson_2.ui.UserFragment
import com.dumdumbich.popularlibraries.lesson_2.ui.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GitHubUser) = FragmentScreen { UserFragment.newInstance(user) }
}