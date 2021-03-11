package com.dumdumbich.popularlibraries.lesson_2.presenter

import com.dumdumbich.popularlibraries.lesson_2.view.IUserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(private val router: Router) : MvpPresenter<IUserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

}