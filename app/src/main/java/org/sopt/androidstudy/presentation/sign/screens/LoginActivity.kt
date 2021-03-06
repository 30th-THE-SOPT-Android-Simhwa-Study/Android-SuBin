package org.sopt.androidstudy.presentation.sign.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import org.sopt.androidstudy.R
import org.sopt.androidstudy.databinding.ActivityLoginBinding
import org.sopt.androidstudy.presentation.home.screens.HomeActivity
import org.sopt.androidstudy.presentation.sign.viewmodels.SignViewModel

class LoginActivity : AppCompatActivity(), LifecycleOwner {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: SignViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@LoginActivity

        goToHome()
    }

    private fun goToHome() {
        viewModel.getSuccess().observe(this) {
            Intent(this, HomeActivity::class.java).run {
                putExtra("userInfo", viewModel.getUserEmail().value)
                startActivity(this)
                finish()
            }
        }
    }
}

