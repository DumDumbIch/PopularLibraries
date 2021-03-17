package com.dumdumbich.popularlibraries.lesson_3.navigation

import com.dumdumbich.popularlibraries.lesson_3.model.entity.GitHubUser
import com.dumdumbich.popularlibraries.lesson_3.ui.UserFragment
import com.dumdumbich.popularlibraries.lesson_3.ui.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GitHubUser) = FragmentScreen { UserFragment.newInstance(user) }
}