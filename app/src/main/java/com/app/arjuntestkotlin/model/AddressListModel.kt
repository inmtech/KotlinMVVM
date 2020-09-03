package com.app.arjuntestkotlin.model

data class AddressListModel(
    val `data`: List<Data>,
    val msg: String,
    val status: Int
){
    data class Data(
        val coupon_code: String,
        val from_date: String,
        val id: String,
        val name: String,
        val to_date: String
    )

}

