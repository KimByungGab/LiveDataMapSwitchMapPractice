package com.example.mapswitchmappractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MainViewModel : ViewModel() {

    // 액티비티 단에서 계속 viewmodel 이용해서 건드리는 거 마음에 들지 않아. viewmodel 안에서만 하고싶어!
    // Transformations -> map / switchMap
    // 현재는 LiveData 코어에 내장되어 있기 때문에 implementation 하지 않아도 된다.

    // 만약 라이브러리를 적용하고싶다면
    // implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.6.2")

    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    fun setLiveDataValue(count : Int) {
        _mutableCount.value = count
    }

    val mapLiveData = liveCount.map {
        it + it
    }

    val switchMapLiveData = liveCount.switchMap {
        MutableLiveData(it * it)
    }
}