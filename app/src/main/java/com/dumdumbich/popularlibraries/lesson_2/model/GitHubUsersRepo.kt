package com.dumdumbich.popularlibraries.lesson_2.model

import com.dumdumbich.popularlibraries.lesson_2.model.entity.GitHubUser

class GitHubUsersRepo {

    private val users = listOf(
        GitHubUser("login_1"),
        GitHubUser("login_2"),
        GitHubUser("login_3"),
        GitHubUser("login_4"),
        GitHubUser("login_5"),
        GitHubUser("login_6"),
        GitHubUser("login_7")
    )

    fun getUsers() = users

}