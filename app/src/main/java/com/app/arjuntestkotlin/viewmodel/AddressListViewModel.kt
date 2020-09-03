package com.app.arjuntestkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.arjuntestkotlin.model.AddressListModel

class AddressListViewModel : ViewModel() {

    val data = MutableLiveData<AddressListModel>()

    fun setRecordData(item: AddressListModel) {
        data.value = item
    }

    fun getRecordData(): MutableLiveData<AddressListModel> {
        return data
    }

}