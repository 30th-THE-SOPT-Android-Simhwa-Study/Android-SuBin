package org.sopt.androidstudy.presentation.home.viewmodels

import androidx.lifecycle.ViewModel
import org.sopt.androidstudy.data.models.UserInfo

class HomeViewModel : ViewModel() {
    private var userInfo: UserInfo? = null

    fun setUserInfo(userInfo: UserInfo) {
        this.userInfo = userInfo
    }
    fun getUserInfo(): UserInfo? = userInfo
}