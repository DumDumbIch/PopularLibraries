package com.dumdumbich.popularlibraries.lesson_2.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserView : MvpView {
    fun setLogin(text: String)
}