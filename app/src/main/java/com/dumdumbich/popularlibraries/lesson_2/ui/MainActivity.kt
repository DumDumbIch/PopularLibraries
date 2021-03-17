package com.dumdumbich.popularlibraries.lesson_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.dumdumbich.popularlibraries.R
import com.dumdumbich.popularlibraries.databinding.ActivityMainBinding
import com.dumdumbich.popularlibraries.lesson_2.navigation.AndroidScreens
import com.dumdumbich.popularlibraries.lesson_2.presenter.MainPresenter
import com.dumdumbich.popularlibraries.lesson_2.view.IMainView
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {

    private val navigator = AppNavigator(this, R.id.container)

    private lateinit var ui: ActivityMainBinding
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(ui.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackClickListener && it.isBackPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

}