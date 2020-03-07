package com.example.martiantimes.model


import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Array.get

@Entity
data class MartianResponse(

    //@ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String?,

    //@ColumnInfo(name = "images")
    @SerializedName("images")
    val image: List<Image?>,

    //@ColumnInfo(name = "body")
    @SerializedName("body")
    val body: String?

)
{
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

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

class ConverterClass() {

    @TypeConverter
    fun imageToString(image: List<Image?>): String {
        val url = image.firstOrNull { it?.topImage == true }
        return url?.url ?: " "
    }


//     @TypeConverter
//     fun imageToList (image: List<String?>){
//
//     }

//    val imageList : List<String>?
//        get() {
//        val image : List<Image>? = null
//        return image?.mapNotNull { it?.url }
}


