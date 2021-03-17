package com.dumdumbich.popularlibraries.lesson_3.presenter

import com.dumdumbich.popularlibraries.lesson_3.model.entity.GitHubUser
import com.dumdumbich.popularlibraries.lesson_3.view.IUserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(private val router: Router, private val user: GitHubUser) : MvpPresenter<IUserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(user.login)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

}