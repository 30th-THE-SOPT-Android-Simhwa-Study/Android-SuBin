package org.sopt.androidstudy

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.sopt.androidstudy.databinding.ActivityMainBinding
import org.sopt.androidstudy.db.*
import org.sopt.androidstudy.presentation.friend.viewmodels.FriendViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var friendViewModel: FriendViewModel

    private var friendRecyclerViewAdapter = FriendRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        initSetting()
        initAdapter()
        displayFriendsList()
    }

    private fun initSetting() {
        val dao = FriendDatabase.getInstance(application).friendDAO
        val repository = FriendRepository(dao)
        val friendViewModelFactory = FriendViewModelFactory(repository)
        friendViewModel =
            ViewModelProvider(this, friendViewModelFactory)[FriendViewModel::class.java]
    }

    private fun initAdapter() {
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.viewModel = friendViewModel
        binding.lifecycleOwner = this

        binding.mainRcv.adapter = friendRecyclerViewAdapter

        friendViewModel.showToast.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }
        })

    }

//    //필요없을듯,,!
//    private fun itemClickEvent() {
//        friendRecyclerViewAdapter.setItemClickListener(object :
//            FriendRecyclerViewAdapter.OnItemClickListener {
//            override fun onClick(view: View, position: Int) {
//                val name = friendRecyclerViewAdapter.currentList[position].name
//                val email = friendRecyclerViewAdapter.currentList[position].email
//            }
//
//        })
//    }

    private fun displayFriendsList() {
        friendViewModel.friends.observe(this) {
            friendRecyclerViewAdapter.submitList(it)
        }
    }
}