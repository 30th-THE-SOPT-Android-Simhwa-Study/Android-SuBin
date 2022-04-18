package org.sopt.androidstudy.presentation.sign.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignViewModel() : ViewModel() {
    private val userEmail = MutableLiveData<String>()
    private val userPassword = MutableLiveData<String>()
    private val isEnabledLoginButton= MutableLiveData<Boolean>()
    private val isVaildEmail = MutableLiveData<Boolean>()
    init{
    initEnabledLoginButton()
    }
    fun initEnabledLoginButton(){

    }
}