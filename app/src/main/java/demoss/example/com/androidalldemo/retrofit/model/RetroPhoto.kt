package demoss.example.com.androidalldemo.retrofit.model

import android.databinding.BaseObservable
import com.google.gson.annotations.SerializedName



class RetroPhoto (
    @SerializedName("albumId") private var albumId : Int,
    @SerializedName("id") private var id : Int,
    @SerializedName("title") private var title : String,
    @SerializedName("url") private var url : String,
    @SerializedName("thumbnailUrl") private var thumbnailUrl : String
    ) : BaseObservable()
{


    fun getAlbumId(): Int? {
        return albumId
    }

    fun setAlbumId(albumId: Int) {
        this.albumId = albumId
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getThumbnailUrl(): String? {
        return thumbnailUrl
    }

    fun setThumbnailUrl(thumbnailUrl: String) {
        this.thumbnailUrl = thumbnailUrl
    }
}