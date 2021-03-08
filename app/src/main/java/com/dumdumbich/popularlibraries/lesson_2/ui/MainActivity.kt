package com.dumdumbich.popularlibraries.lesson_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.dumdumbich.popularlibraries.databinding.ActivityMainBinding
import com.dumdumbich.popularlibraries.lesson_2.model.GitHubUsersRepo
import com.dumdumbich.popularlibraries.lesson_2.presenter.UsersPresenter
import com.dumdumbich.popularlibraries.lesson_2.view.IUsersView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IUsersView {

    private lateinit var ui: ActivityMainBinding
    private val presenter by moxyPresenter {
        UsersPresenter(GitHubUsersRepo())
    }

    private lateinit var adapter: UsersRVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(ui.root)

    }

    override fun init() {
        ui.rvUsers.layoutManager = LinearLayoutManager(this)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        ui.rvUsers.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }
}