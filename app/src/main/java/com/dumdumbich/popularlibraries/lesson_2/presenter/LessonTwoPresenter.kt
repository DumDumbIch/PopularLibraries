package com.dumdumbich.popularlibraries.lesson_2.presenter

import com.dumdumbich.popularlibraries.lesson_2.model.CountersModel
import com.dumdumbich.popularlibraries.lesson_2.view.ICountersView
import moxy.MvpPresenter

class LessonTwoPresenter(private val model: CountersModel): MvpPresenter<ICountersView>() {

    private fun getCounter1() = model.counter1
    private fun getCounter2() = model.counter2
    private fun getCounter3() = model.counter3

    private fun incCounter1() = ++model.counter1
    private fun incCounter2() = ++model.counter2
    private fun incCounter3() = ++model.counter3

    fun initCounters() {
        viewState.setTextButtonCounter1(getCounter1().toString())
        viewState.setTextButtonCounter2(getCounter2().toString())
        viewState.setTextButtonCounter3(getCounter3().toString())
    }

    fun clickCounter1() {
        viewState.setTextButtonCounter1(incCounter1().toString())
    }

    fun clickCounter2() {
        viewState.setTextButtonCounter2(incCounter2().toString())
    }

    fun clickCounter3() {
        viewState.setTextButtonCounter3(incCounter3().toString())
    }

}