package org.sopt.androidstudy.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.androidstudy.presentation.friend.viewmodels.FriendDetailViewModel

class FriendDetailViewModelFactory(private val repository: FriendRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FriendDetailViewModel::class.java)) {
            return FriendDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
