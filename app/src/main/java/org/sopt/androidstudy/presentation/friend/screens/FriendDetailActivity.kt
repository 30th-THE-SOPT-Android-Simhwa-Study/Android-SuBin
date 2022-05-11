package org.sopt.androidstudy.presentation.friend.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

import androidx.lifecycle.ViewModelProvider
import org.sopt.androidstudy.FriendLocalDataSource
import org.sopt.androidstudy.R
import org.sopt.androidstudy.databinding.ActivityFriendDetailBinding

import org.sopt.androidstudy.db.*
import org.sopt.androidstudy.presentation.friend.viewmodels.FriendDetailViewModel


class FriendDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFriendDetailBinding
    private val viewModel: FriendDetailViewModel by lazy {
        val dao = FriendDatabase.getInstance(application).friendDAO
        val friendrepositoryImpl = FriendRepositoryImpl(FriendLocalDataSource(dao))
        ViewModelProvider(
            this,
            FriendDetailViewModelFactory(friendrepositoryImpl)
        )[FriendDetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_friend_detail)
        binding.viewModel = viewModel

        intent.getParcelableExtra<Friend>(FRIEND_INFO)?.let { friend ->
            viewModel.setFriend(friend)
        }
    }

    companion object {
        private const val FRIEND_INFO = "friend"
    }
}