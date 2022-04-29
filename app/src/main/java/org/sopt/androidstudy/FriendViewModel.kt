package org.sopt.androidstudy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.androidstudy.db.Friend
import org.sopt.androidstudy.db.FriendRepository

class FriendViewModel(private val repository: FriendRepository): ViewModel() {

    val friends = repository.friends

    val inputName = MutableLiveData<String?>()
    val inputEmail = MutableLiveData<String?>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value= "저장"
        clearAllOrDeleteButtonText.value= "전체 삭제"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Friend(0, name, email))
        inputName.value= null
        inputEmail.value= null
    }

    fun clearAllOrDelete(){
        clearAll()
    }

    fun insert(Friend: Friend){
        viewModelScope.launch{
            repository.insert(Friend)
        }
    }

    fun update(Friend: Friend){
        viewModelScope.launch{
            repository.update(Friend)
        }
    }

    fun delete(Friend: Friend){
        viewModelScope.launch{
            repository.delete(Friend)
        }
    }

    fun clearAll(){
        viewModelScope.launch{
            repository.deleteAll()
        }
    }

}