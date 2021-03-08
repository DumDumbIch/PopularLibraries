package com.dumdumbich.popularlibraries.lesson_2.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUsersView : MvpView {
    fun init()
    fun updateList()
}