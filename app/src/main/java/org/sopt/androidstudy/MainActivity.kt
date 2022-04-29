package org.sopt.androidstudy
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.sopt.androidstudy.databinding.ActivityMainBinding
import org.sopt.androidstudy.db.FriendDatabase
import org.sopt.androidstudy.db.FriendRepository
import org.sopt.androidstudy.db.FriendViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var friendViewModel: FriendViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = FriendDatabase.getInstance(application).friendDAO
        val repository = FriendRepository(dao)
        val factory = FriendViewModelFactory(repository)

        friendViewModel = ViewModelProvider(this, factory).get(FriendViewModel::class.java)

        binding.viewModel = friendViewModel
        binding.lifecycleOwner = this

        displayFriendsList()
    }

    private fun displayFriendsList(){
        friendViewModel.friends.observe(this, Observer{
            Log.i("LEE", it.toString())
        })
    }

}