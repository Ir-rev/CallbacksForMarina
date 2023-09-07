package com.example.myapplication.ui.main

import android.graphics.Bitmap

/**
 * Колбек для загруски картинок
 */
interface ImageLoaderCallback {

    /** начало загрузки */
    fun onStartLoading(url: String)

    /** возвращает прогресс загрузки каждый % */
    fun onProgressChanged(progress: Int)

    /** картинка загружена */
    fun onLoaded(bitmap: Bitmap)

}

