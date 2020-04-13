package com.example.martiantimes.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.io.InputStream
import java.lang.Exception

class DownloadImageTask : AsyncTask<String, Void, Bitmap>() {

    lateinit var imageView: ImageView

    override fun doInBackground(vararg url: String?): Bitmap? {
        val urlDisplay: String? = url[0]
        var bmp: Bitmap? = null
        try {
            val inputStream: InputStream = java.net.URL(urlDisplay).openStream()
            bmp = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            Log.e("Error", e.toString())
            e.printStackTrace()
        }
        return bmp
    }

    override fun onPostExecute(result: Bitmap) {
        imageView.setImageBitmap(result)
    }


}