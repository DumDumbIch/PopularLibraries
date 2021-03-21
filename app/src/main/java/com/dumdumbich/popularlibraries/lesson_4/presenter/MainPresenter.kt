package com.dumdumbich.popularlibraries.lesson_4.presenter

import com.dumdumbich.popularlibraries.lesson_4.model.navigation.IScreens
import com.dumdumbich.popularlibraries.lesson_4.view.IMainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, private val screens: IScreens) :
    MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.convertImage())
    }

    fun backClicked() {
        router.exit()
    }

}