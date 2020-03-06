package com.example.martiantimes.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MartianResponse(

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String?,

    @ColumnInfo(name = "images")
    @SerializedName("images")
    val image: List<Image?>,

    @ColumnInfo(name = "body")
    @SerializedName("body")
    val body: String?

) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

    //@ColumnInfo("images")
    val imageUrl :String? get() {
        var url = image.firstOrNull { it?.topImage == true }
         return url?.url ?: " "
    }
   // @ColumnInfo
    val imageList : List<String?> get() = image.mapNotNull { it?.url }

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
