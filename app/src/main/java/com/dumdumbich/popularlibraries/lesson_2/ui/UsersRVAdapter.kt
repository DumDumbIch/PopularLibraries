package com.dumdumbich.popularlibraries.lesson_2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dumdumbich.popularlibraries.databinding.ItemUserBinding
import com.dumdumbich.popularlibraries.lesson_2.presenter.list.IUsersListPresenter
import com.dumdumbich.popularlibraries.lesson_2.view.list.IUserItemView

class UsersRVAdapter(private val presenter: IUsersListPresenter) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()


    inner class ViewHolder(private val ui: ItemUserBinding) : RecyclerView.ViewHolder(ui.root),
        IUserItemView {

        override var pos = -1

        override fun setLogin(text: String) = with(ui) {
            tvLogin.text = text
        }
    }

}