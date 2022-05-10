package org.sopt.androidstudy.db

import androidx.lifecycle.LiveData
import org.sopt.androidstudy.data.models.types.MBTI
import org.sopt.androidstudy.data.models.types.MBTIFeatures

interface FriendRepository {

    val friends: LiveData<List<Friend>>

    suspend fun insert(friend: Friend)

    suspend fun update(friend: Friend)

    suspend fun delete(friend: Friend)

    suspend fun deleteAll()

    fun getMBTIFeatures(mbti: MBTI): List<MBTIFeatures>

    fun getAll(): LiveData<List<Friend>>
}