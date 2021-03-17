package com.dumdumbich.popularlibraries.lesson_3.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(
    val login: String
) : Parcelable