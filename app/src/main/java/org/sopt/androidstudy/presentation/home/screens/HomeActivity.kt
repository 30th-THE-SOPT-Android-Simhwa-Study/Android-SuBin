package org.sopt.androidstudy.presentation.home.screens

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidstudy.R
import org.sopt.androidstudy.data.models.UserInfo
import org.sopt.androidstudy.databinding.ActivityHomeBinding
import org.sopt.androidstudy.presentation.home.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = viewModel
        intent.getParcelableExtra<UserInfo>("userInfo")?.let { user ->
            viewModel.setUserInfo(user)
        }
       /* viewModel 적용 전
       intent.getParcelableExtra<UserInfo>("userData")
            ?.let { user -> binding.email.text = user.email }*/
    }
}
