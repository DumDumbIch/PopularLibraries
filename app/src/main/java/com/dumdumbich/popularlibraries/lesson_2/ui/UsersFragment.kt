package com.dumdumbich.popularlibraries.lesson_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dumdumbich.popularlibraries.databinding.FragmentUsersBinding
import com.dumdumbich.popularlibraries.lesson_2.model.GitHubUsersRepo
import com.dumdumbich.popularlibraries.lesson_2.navigation.AndroidScreens
import com.dumdumbich.popularlibraries.lesson_2.presenter.UsersPresenter
import com.dumdumbich.popularlibraries.lesson_2.view.IUsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), IUsersView, IBackClickListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter by moxyPresenter {
        UsersPresenter(GitHubUsersRepo(), App.instance.router, AndroidScreens())
    }

    private var ui: FragmentUsersBinding? = null
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        ui = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun init() {
        ui?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        ui?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun isBackPressed() = presenter.backClick()

}