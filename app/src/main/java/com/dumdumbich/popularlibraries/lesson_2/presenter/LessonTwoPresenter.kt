package com.dumdumbich.popularlibraries.lesson_2.presenter

import com.dumdumbich.popularlibraries.lesson_2.model.CountersModel
import com.dumdumbich.popularlibraries.lesson_2.view.ICountersView
import moxy.MvpPresenter

class LessonTwoPresenter(val model: CountersModel): MvpPresenter<ICountersView>() {

    fun getCounter1() = model.counter1
    fun getCounter2() = model.counter2
    fun getCounter3() = model.counter3

    fun setCounter1(value: Int) {
        model.counter1 = value
    }

    fun setCounter2(value: Int) {
        model.counter2 = value
    }

    fun setCounter3(value: Int) {
        model.counter3 = value
    }

    private fun incCounter1() = ++model.counter1
    private fun incCounter2() = ++model.counter2
    private fun incCounter3() = ++model.counter3

    fun updateCounters() {
        viewState.setTextButtonCounter1(getCounter1().toString())
        viewState.setTextButtonCounter2(getCounter2().toString())
        viewState.setTextButtonCounter3(getCounter3().toString())
    }

    fun clearCounters() {
        model.counter1 = 0
        model.counter2 = 0
        model.counter3 = 0
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