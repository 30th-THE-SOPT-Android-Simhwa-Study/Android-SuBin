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
    private var friendRecyclerViewAdapter = FriendRecyclerViewAdapter()

    private val friendViewModel: FriendViewModel by lazy {
        val dao = FriendDatabase.getInstance(application).friendDAO
        val repositoryImpl = FriendRepositoryImpl(FriendLocalDataSource(dao))
        ViewModelProvider(this, FriendViewModelFactory(repositoryImpl))[FriendViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = friendViewModel
        binding.lifecycleOwner = this

        initAdapter()
        displayFriendsList()
    }


    private fun initAdapter() {
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = friendRecyclerViewAdapter

        friendViewModel.showToast.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }
        })

    }

    //아이템클릭!
    private fun itemClickEvent() {
        friendRecyclerViewAdapter.setItemClickListener(object :
            FriendRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                val name = friendRecyclerViewAdapter.currentList[position].name
                val email = friendRecyclerViewAdapter.currentList[position].email
            }

        })
    }

    private fun displayFriendsList() {
        friendViewModel.friends.observe(this) {
            friendRecyclerViewAdapter.submitList((it.toMutableList()))
        }
    }
}