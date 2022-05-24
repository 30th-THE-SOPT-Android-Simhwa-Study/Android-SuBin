package org.sopt.androidstudy.presentation.friend.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.androidstudy.data.models.types.MBTI
import org.sopt.androidstudy.data.models.types.MBTIFeatures
import org.sopt.androidstudy.db.Friend
import org.sopt.androidstudy.db.FriendRepository

class FriendDetailViewModel(val repository: FriendRepository) : ViewModel() {
    private val friend = MutableLiveData<Friend>()

    fun setFriend(friend: Friend) {
        this.friend.value = friend
    }

    fun getFriend(): LiveData<Friend> = friend

    // TODO FriendRepository의 getMBTIFeature 함수로 mbti 속성을 가져와볼까요~!
    fun getMBTIFeature(mbti: MBTI): List<MBTIFeatures> = repository.getMBTIFeatures(mbti)

    companion object {
        private const val TAG = "FriendDetailViewModel"
    }
}