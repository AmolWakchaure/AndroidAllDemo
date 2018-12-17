package demoss.example.com.androidalldemo.retrofit.view

import demoss.example.com.androidalldemo.retrofit.model.RetroPhoto
import retrofit2.Call
import retrofit2.http.GET



interface GetDataService {

    @GET("/photos")
    fun getAllPhotos(): Call<List<RetroPhoto>>
}