package com.dumdumbich.popularlibraries.lesson_3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dumdumbich.popularlibraries.databinding.FragmentUserBinding
import com.dumdumbich.popularlibraries.lesson_3.model.entity.GitHubUser
import com.dumdumbich.popularlibraries.lesson_3.presenter.UserPresenter
import com.dumdumbich.popularlibraries.lesson_3.view.IUserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(), IUserView,
    IBackClickListener {

    companion object {
        private const val USER_ARG = "user"

        fun newInstance(user: GitHubUser) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, user)
            }
        }
    }

    private val presenter by moxyPresenter {
        val user = arguments?.getParcelable<GitHubUser>(USER_ARG) as GitHubUser
        UserPresenter(App.instance.router, user)
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

    override fun setLogin(text: String) {
        ui?.tvUserLogin?.text = text
    }

    override fun isBackPressed() = presenter.backClick()

}