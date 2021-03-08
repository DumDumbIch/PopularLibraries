package com.dumdumbich.popularlibraries.lesson_2.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleTagStrategy::class)
interface ICountersView: MvpView {
    fun setTextButtonCounter1(text: String)
    fun setTextButtonCounter2(text: String)
    fun setTextButtonCounter3(text: String)
}