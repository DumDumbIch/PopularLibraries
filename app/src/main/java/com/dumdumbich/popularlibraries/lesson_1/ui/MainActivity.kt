package com.dumdumbich.popularlibraries.lesson_1.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.dumdumbich.popularlibraries.databinding.ActivityMainBinding
import com.dumdumbich.popularlibraries.lesson_1.presenter.MainPresenter
import com.dumdumbich.popularlibraries.lesson_1.view.ICountersView

class MainActivity : AppCompatActivity(), ICountersView {

    private lateinit var ui: ActivityMainBinding
    private val presenter = MainPresenter(view = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(ui.root)
        initView()
    }

    private fun initView() {
        presenter.clearCounters()
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