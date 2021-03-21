package com.dumdumbich.popularlibraries.lesson_4.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IConvertImageView : MvpView {
    fun init()
    fun showConvertInProgress()
    fun hideConvertInProgress()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun selectImage()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showConvertSuccess()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showConvertCancel()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showConvertError()
}