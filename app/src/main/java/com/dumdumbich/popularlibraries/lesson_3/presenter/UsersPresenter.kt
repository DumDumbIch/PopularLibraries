package com.dumdumbich.popularlibraries.lesson_3.presenter

import com.dumdumbich.popularlibraries.lesson_3.model.GitHubUsersRepo
import com.dumdumbich.popularlibraries.lesson_3.model.entity.GitHubUser
import com.dumdumbich.popularlibraries.lesson_3.navigation.IScreens
import com.dumdumbich.popularlibraries.lesson_3.presenter.list.IUsersListPresenter
import com.dumdumbich.popularlibraries.lesson_3.view.IUsersView
import com.dumdumbich.popularlibraries.lesson_3.view.list.IUserItemView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitHubUsersRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<IUsersView>() {

    class UsersListPresenter : IUsersListPresenter {

        val users = mutableListOf<GitHubUser>()

        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size

    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { view ->
            val user = usersListPresenter.users[view.pos]
            router.navigateTo(screens.user(user))
        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.clear()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

}