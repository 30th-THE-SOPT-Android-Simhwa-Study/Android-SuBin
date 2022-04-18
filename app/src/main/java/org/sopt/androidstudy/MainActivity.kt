package org.sopt.androidstudy
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import org.sopt.androidstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleOwner {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this@MainActivity
        binding.viewModel = viewModel
    }
}