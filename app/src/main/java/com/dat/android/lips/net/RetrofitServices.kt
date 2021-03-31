package com.dat.android.lips.net

import com.dat.android.lips.model.Model
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("grab_v1_ap.php?av1_ap=prila123&size=full_size&margin=true&onboard=false&ref=uid19012930&page=12&num=104")
    fun getMovieList(): Call<Model>

}