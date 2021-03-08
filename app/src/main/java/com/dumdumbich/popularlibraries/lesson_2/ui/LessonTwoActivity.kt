package com.dumdumbich.popularlibraries.lesson_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.dumdumbich.popularlibraries.databinding.ActivityLessonTwoBinding
import com.dumdumbich.popularlibraries.lesson_2.model.CountersModel
import com.dumdumbich.popularlibraries.lesson_2.presenter.LessonTwoPresenter
import com.dumdumbich.popularlibraries.lesson_2.view.ICountersView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class LessonTwoActivity : MvpAppCompatActivity(), ICountersView {

    private lateinit var ui: ActivityLessonTwoBinding
    private val presenter by moxyPresenter {
        LessonTwoPresenter(CountersModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityLessonTwoBinding.inflate(LayoutInflater.from(this))
        setContentView(ui.root)
        initView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNTER_1", presenter.getCounter1())
        outState.putInt("COUNTER_2", presenter.getCounter2())
        outState.putInt("COUNTER_3", presenter.getCounter3())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.setCounter1(savedInstanceState.getInt("COUNTER_1"))
        presenter.setCounter2(savedInstanceState.getInt("COUNTER_2"))
        presenter.setCounter3(savedInstanceState.getInt("COUNTER_3"))
        presenter.updateCounters()
    }

    private fun initView() {
        presenter.clearCounters()
        presenter.updateCounters()
        ui.btnCounter1.setOnClickListener { presenter.clickCounter1() }
        ui.btnCounter2.setOnClickListener { presenter.clickCounter2() }
        ui.btnCounter3.setOnClickListener { presenter.clickCounter3() }
    }

    override fun setTextButtonCounter1(text: String) {
        ui.btnCounter1.text = text
    }

    override fun setTextButtonCounter2(text: String) {
        ui.btnCounter2.text = text
    }

    override fun setTextButtonCounter3(text: String) {
        ui.btnCounter3.text = text
    }

}