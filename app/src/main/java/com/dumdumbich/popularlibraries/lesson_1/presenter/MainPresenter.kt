package com.dumdumbich.popularlibraries.lesson_1.presenter

import com.dumdumbich.popularlibraries.lesson_1.model.CountersModel
import com.dumdumbich.popularlibraries.lesson_1.view.ICountersView

class MainPresenter(val view: ICountersView) {

    private val model = CountersModel()

    fun updateCounters(){
        view.setTextButtonCounter1(model.counter1.toString())
        view.setTextButtonCounter2(model.counter2.toString())
        view.setTextButtonCounter3(model.counter3.toString())
    }

    fun clearCounters() {
        model.clearCounter1()
        model.clearCounter2()
        model.clearCounter3()
        updateCounters()
    }

    fun clickCounter1() {
        view.setTextButtonCounter1(model.incCounter1().toString())
    }

    fun clickCounter2() {
        view.setTextButtonCounter2(model.incCounter2().toString())
    }

    fun clickCounter3() {
        view.setTextButtonCounter3(model.incCounter3().toString())
    }

}