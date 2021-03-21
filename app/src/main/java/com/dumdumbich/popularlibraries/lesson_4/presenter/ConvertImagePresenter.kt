package com.dumdumbich.popularlibraries.lesson_4.presenter

import android.util.Log
import com.dumdumbich.popularlibraries.lesson_4.model.converter.IConverter
import com.dumdumbich.popularlibraries.lesson_4.model.converter.Image
import com.dumdumbich.popularlibraries.lesson_4.model.navigation.IScreens
import com.dumdumbich.popularlibraries.lesson_4.view.IConvertImageView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class ConvertImagePresenter(
    private val router: Router,
    private val screens: IScreens,
    private val uiScheduler: Scheduler,
    private val converter: IConverter
) : MvpPresenter<IConvertImageView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    fun selectAndConvertImageClick() {
        Log.d("CONVERTER","ConverterImagePresenter : selectAndConvertImageClick()")
        viewState.selectImage()
    }

    var conversionDisposable: Disposable? = null
    fun imageSelected(image: Image) {
        viewState.showConvertInProgress()
        conversionDisposable = converter.convert(image)
            .observeOn(uiScheduler)
            .subscribe({
                viewState.hideConvertInProgress()
                viewState.showConvertSuccess()
            }, {
                viewState.hideConvertInProgress()
                viewState.showConvertError()
            })
    }

    fun convertCancel() {
        conversionDisposable?.dispose()
        viewState.hideConvertInProgress()
        viewState.showConvertCancel()
    }

}