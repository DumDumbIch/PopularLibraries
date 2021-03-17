package com.dumdumbich.popularlibraries.lesson_3.model

import com.dumdumbich.popularlibraries.lesson_3.model.entity.GitHubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

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

    fun getUsers(): Observable<GitHubUser> = Observable.fromIterable(users)

}