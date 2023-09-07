package com.example.myapplication.ui.main

import android.graphics.Bitmap
import android.graphics.Color

class ImageLoader(
    private val imageLoaderCallback: ImageLoaderCallback
) {

    /* мок для проверки колбека */
    fun loadImage(url: String) {
        Thread{
            // начал качать отправил колбек
            imageLoaderCallback.onStartLoading(url)
            Thread.sleep(100)

            // сдесь типо качаю с прогресом
            for (i in 1..100){
                Thread.sleep(10)
                imageLoaderCallback.onProgressChanged(i)
            }
            Thread.sleep(10)

            // создал картинку
            val bitmap = Bitmap.createBitmap(
                100, 100,
                Bitmap.Config.ARGB_8888
            )
            // Закрашиваем синим цветом
            bitmap.eraseColor(Color.BLUE)

            // вернул через колбек
            imageLoaderCallback.onLoaded(bitmap)
        }.start()
    }

}