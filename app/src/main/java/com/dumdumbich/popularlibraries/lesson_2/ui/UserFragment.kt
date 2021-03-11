package com.dumdumbich.popularlibraries.lesson_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dumdumbich.popularlibraries.databinding.FragmentUserBinding
import com.dumdumbich.popularlibraries.lesson_2.model.entity.GitHubUser
import com.dumdumbich.popularlibraries.lesson_2.presenter.UserPresenter
import com.dumdumbich.popularlibraries.lesson_2.view.IUserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment(private val user: GitHubUser) : MvpAppCompatFragment(), IUserView,
    IBackClickListener {

    companion object {
        fun newInstance(user: GitHubUser) = UserFragment(user)
    }

    private val presenter by moxyPresenter {
        UserPresenter(App.instance.router)
    }

    private var ui: FragmentUserBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        ui?.tvUserLogin?.text = user.login
    }

    override fun isBackPressed() = presenter.backClick()

}