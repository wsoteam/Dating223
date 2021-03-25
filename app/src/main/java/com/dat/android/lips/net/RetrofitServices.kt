package com.dat.android.lips.net

import com.dat.android.lips.model.Model
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("grab_v1_ap.php?av1_ap=prila123&api=old&next=release2&prev=outdated&getter=old&setup=page_of&num=104")
    fun getMovieList(): Call<Model>

}