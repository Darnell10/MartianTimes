package com.example.martiantimes.model

import com.google.gson.annotations.SerializedName



data class MartianResponse(

    @SerializedName("title")
    val title: String?,

    @SerializedName("images")
    val image: List<Image?>,

    @SerializedName("body")
    val body: String?

)
{

    val imageUrl: String?
        get() {
            var url = image.firstOrNull { it?.topImage == true }
            return url?.url ?: " "
        }

    val imageList: List<String?> get() = image.mapNotNull { it?.url }

    fun imageToString(image: List<Image?>): String {
        val url = image.firstOrNull { it?.topImage == true }
        return url?.url ?: " "
    }

}

data class Image(
    @SerializedName("top_image")
    val topImage: Boolean?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?
)

//class ConverterClass() {
//
//    @TypeConverter
//    fun imageToString(image: List<Image?>): String {
//        val url = image.firstOrNull { it?.topImage == true }
//        return url?.url ?: " "
//    }


//     @TypeConverter
//     fun imageToList (image: List<String?>){
//
//     }

//    val imageList : List<String>?
//        get() {
//        val image : List<Image>? = null
//        return image?.mapNotNull { it?.url }
//}


