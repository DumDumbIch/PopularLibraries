package com.dumdumbich.popularlibraries.lesson_4.ui.converter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.dumdumbich.popularlibraries.lesson_4.model.converter.IConverter
import com.dumdumbich.popularlibraries.lesson_4.model.converter.Image
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.File
import java.io.FileOutputStream

class AndroidConverter(private val context: Context?) : IConverter {

    override fun convert(image: Image): Completable = Completable.fromAction {
        Log.d("CONVERTER","AndroidConverter : convert()")
        context?.let { context ->
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                return@let
            }
            val bitmap = BitmapFactory.decodeByteArray(image.data, 0, image.data.size)
            val dstFile = File(context.getExternalFilesDir(null), "converted.png")
            val stream = FileOutputStream(dstFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        }
    }.subscribeOn(Schedulers.io())

}