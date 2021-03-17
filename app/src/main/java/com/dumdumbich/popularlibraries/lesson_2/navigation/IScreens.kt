package com.dumdumbich.popularlibraries.lesson_2.navigation

import com.dumdumbich.popularlibraries.lesson_2.model.entity.GitHubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GitHubUser): Screen
}