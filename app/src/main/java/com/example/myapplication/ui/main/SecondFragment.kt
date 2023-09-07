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

class SecondFragment : Fragment(), ImageLoaderCallback  {

    companion object {
        fun newInstance() = SecondFragment()
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

        val imageLoader = ImageLoader(this)

        button.setOnClickListener {
            imageLoader.loadImage("bitmap.php")
        }
    }

    override fun onStartLoading(url: String) {
        val progressTextView = view?.findViewById<TextView>(R.id.progress)
        activity?.runOnUiThread {
            progressTextView?.text = "началась загрузка $url"
        }
    }

    override fun onProgressChanged(progress: Int) {
        val progressTextView = view?.findViewById<TextView>(R.id.progress)
        activity?.runOnUiThread {
            progressTextView?.text = "прогресс $progress"
        }
    }

    override fun onLoaded(bitmap: Bitmap) {
        val progressTextView = view?.findViewById<TextView>(R.id.progress)
        val image = view?.findViewById<ImageView>(R.id.imageView)
        activity?.runOnUiThread {
            progressTextView?.text = "картинка загружена"
            image?.setImageBitmap(bitmap)
        }
    }

}