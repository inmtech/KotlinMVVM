package com.app.kotlindemo.network

import com.app.arjuntestkotlin.model.AddressListModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


/**
 *
 */
interface ApiServices {
    @POST("allNotifications.php")
    fun getDataList(@Body param: JsonObject): Call<AddressListModel>




}