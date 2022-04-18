package org.sopt.androidstudy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val count = MutableLiveData(0)

    fun increase() {
        count.value = count.value?.plus(1) // ?의미는 null값도 생각해줌, null이 아니면 +1를 해줌
    }

    fun getCount(): LiveData<Int> = count
}