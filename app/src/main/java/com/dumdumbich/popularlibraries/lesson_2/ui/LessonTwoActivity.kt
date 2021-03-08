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
        initClickListeners()
    }

    private fun initClickListeners() {
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