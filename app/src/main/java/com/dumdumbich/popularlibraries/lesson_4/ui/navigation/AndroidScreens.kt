package com.dumdumbich.popularlibraries.lesson_4.ui.navigation

import com.dumdumbich.popularlibraries.lesson_4.model.navigation.IScreens
import com.dumdumbich.popularlibraries.lesson_4.ui.fragment.ConvertImageFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun convertImage()= FragmentScreen { ConvertImageFragment.newInstance() }
}