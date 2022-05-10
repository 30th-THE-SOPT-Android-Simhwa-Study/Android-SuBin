package org.sopt.androidstudy.presentation.friend.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.androidstudy.db.Friend

class FriendDetailViewModel : ViewModel() {
    private val friend = MutableLiveData<Friend>()

    fun setFriend(friend: Friend) {
        this.friend.value = friend
    }

    fun getFriend(): LiveData<Friend> = friend

    fun getMBTIFeature(){

    }

    // TODO FriendRepository의 getMBTIFeature 함수로 mbti 속성을 가져와볼까요~!

    companion object {
        private const val TAG = "FriendDetailViewModel"
    }
}