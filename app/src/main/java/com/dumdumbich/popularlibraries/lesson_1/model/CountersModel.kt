package com.dumdumbich.popularlibraries.lesson_1.model

class CountersModel {

    var counter1 = 0
        private set(value) {
            field = value
        }
    var counter2 = 0
        private set(value) {
            field = value
        }
    var counter3 = 0
        private set(value) {
            field = value
        }

    fun clearCounter1() {
        counter1 = 0
    }

    fun clearCounter2() {
        counter2 = 0
    }

    fun clearCounter3() {
        counter3 = 0
    }

    fun incCounter1() = ++counter1
    fun incCounter2() = ++counter2
    fun incCounter3() = ++counter3

}