package com.example.myapplication.ui.main

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.dowload)
        val progressTextView = view.findViewById<TextView>(R.id.progress)
        val image = view.findViewById<ImageView>(R.id.imageView)

        // анонимный колбек создается там где нужен
        val imageLoader = ImageLoader(
            imageLoaderCallback = object : ImageLoaderCallback {

                override fun onStartLoading(url: String) {
                    activity?.runOnUiThread {
                        progressTextView.text = "началась загрузка $url"
                    }
                }

                override fun onProgressChanged(progress: Int) {
                    activity?.runOnUiThread {
                        progressTextView.text = "прогресс $progress"
                    }
                }

                override fun onLoaded(bitmap: Bitmap) {
                    activity?.runOnUiThread {
                        progressTextView.text = "картинка загружена"
                        image.setImageBitmap(bitmap)
                    }
                }

            }
        )

        button.setOnClickListener {
            imageLoader.loadImage("bitmap.php")
        }
    }

}