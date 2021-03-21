package com.dumdumbich.popularlibraries.lesson_4.model.converter

import io.reactivex.rxjava3.core.Completable

interface IConverter {
    fun convert(image: Image): Completable
}