package org.sopt.androidstudy.presentation.friend.viewmodels

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.sopt.androidstudy.data.models.types.MBTI
import org.sopt.androidstudy.db.Event
import org.sopt.androidstudy.db.Friend
import org.sopt.androidstudy.db.FriendRepository
import org.sopt.androidstudy.util.safeValueOf

class FriendViewModel(private val repository: FriendRepository) : ViewModel() {

    //Friend data
    val friends = repository.friends
    val position = MutableLiveData<Int?>()
    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()
    val inputMbti = MutableLiveData<String?>()


    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    //Toast
    private val toastMessage = MutableLiveData<Event<Boolean>>()
    val showToast: LiveData<Event<Boolean>> = toastMessage

    init {
        initValue()
    }

    fun saveOrUpdate() {
        if (!inputName.value.isNullOrBlank() && !inputEmail.value.isNullOrBlank()) {
            val name = inputName.value!!
            val email = inputEmail.value!!
            val mbti = inputMbti.value!!
            if (position.value == null) {
                insert(Friend(0, name, email,safeValueOf<MBTI>(mbti.uppercase()).toString()))
            }
        }
    }

    fun onStartEvent() {
        toastMessage.value = Event(true)
    }

    fun clearAllOrDelete() {
        if (position.value == null) clearAll() else {
            delete(friends.value!!.get(position.value!!))
            initValue()
        }
    }

    fun insert(friend: Friend) {
        viewModelScope.launch {
            repository.insert(friend)
            onStartEvent()
            initValue()
        }

    }

    fun update(friend: Friend) {
        viewModelScope.launch {
            repository.update(friend)
        }
    }

    fun delete(friend: Friend) {
        viewModelScope.launch {
            repository.delete(friend)
        }
    }

    fun clearAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    private fun initValue() {
        saveOrUpdateButtonText.value = "??????"
        clearAllOrDeleteButtonText.value = "?????? ??????"
        position.value = null
        inputName.value = null
        inputEmail.value = null
        inputMbti.value = null
    }
}