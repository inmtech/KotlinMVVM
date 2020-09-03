package com.app.arjuntestkotlin.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.arjuntestkotlin.R
import com.app.arjuntestkotlin.database.EntityAddress
import com.app.arjuntestkotlin.database.MyAppDatabase
import com.app.arjuntestkotlin.model.AddressListModel
import com.app.arjuntestkotlin.view.adapter.ListDataAdapter
import com.app.kotlindemo.network.ApiClient
import com.app.kotlindemo.network.ApiPresenter
import com.app.kotlindemo.network.ApiServices
import com.app.kotlindemo.network.RetrofitListener
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call

class HomeActivity : AppCompatActivity(), RetrofitListener {

    var listData: ArrayList<EntityAddress> = ArrayList()
    var apiServices: ApiServices? = null
//    var viewModel: AddressListViewModel? = null
    var adapter: ListDataAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setRecyclerviewAdapter()
        callListOfAddress()
        /*viewModel?.getRecordData()?.observe(this, Observer {
            listData.clear()
            listData = it.data as ArrayList<AddressListModel.Data>
            adapter?.notifyDataSetChanged()
        })*/

        MyAppDatabase.getInstance(this).daoAdddress().allNotes.observe(this, Observer {
            listData.clear()
            listData = it as ArrayList<EntityAddress>
            setRecyclerviewAdapter()
        })

    }

    private fun init() {
        apiServices = ApiClient().getClient()?.create(ApiServices::class.java)
        callListOfAddress()
    }

    private fun callListOfAddress() {
        relLoader.visibility = View.VISIBLE
        var call: Call<AddressListModel>? = null
        var json: JsonObject = JsonObject()
        json.addProperty("api_key", "ICXE1wOphgKgcyMoHr0hVHbbJ")
        call = apiServices?.getDataList(json)
        ApiPresenter.call(call, this, this)
    }

    private fun setRecyclerviewAdapter() {
        recyclerviewList.layoutManager = LinearLayoutManager(this)
        adapter = ListDataAdapter(listData, this)
        recyclerviewList.adapter = adapter

    }

    override fun <T> retrofitOnSuccessResponse(response: T) {

        var arrlistData: AddressListModel
        relLoader.visibility = View.GONE
        if (response is AddressListModel) {
            arrlistData = response as AddressListModel
            listData?.clear()
//            listData?.addAll(arrlistData.data)
            var list:ArrayList<AddressListModel.Data> = ArrayList()
            list.addAll(arrlistData.data)
            MyAppDatabase.getInstance(this).daoAdddress().deleteAll()
            for (i in list.iterator()) {
                MyAppDatabase.getInstance(this).daoAdddress()
                    .addNote(EntityAddress(i.id, i.coupon_code, i.from_date, i.to_date, i.name))
            }

//            viewModel?.setRecordData(arrlistData)
        }
    }

    override fun <T> retrofitOnFailureResponse(fail: T) {
        Toast.makeText(this, getString(R.string.error_something_wrong), Toast.LENGTH_LONG).show()
    }


}