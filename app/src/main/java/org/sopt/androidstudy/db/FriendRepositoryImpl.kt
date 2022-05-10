package org.sopt.androidstudy.db

import androidx.lifecycle.LiveData
import org.sopt.androidstudy.FriendLocalDataSource
import org.sopt.androidstudy.data.models.types.MBTI
import org.sopt.androidstudy.data.models.types.MBTIFeatures

abstract class FriendRepositoryImpl(private val friendLocalDataSource: FriendLocalDataSource):

    FriendRepository {
    override fun getAll(): LiveData<List<Friend>> {
        return friendLocalDataSource.getAll()
    }

    override suspend fun insert(friend: Friend) {
        friendLocalDataSource.insert(friend)
    }

    override suspend fun update(friend: Friend) {
        friendLocalDataSource.update(friend)
    }

    override suspend fun delete(friend: Friend) {
        friendLocalDataSource.delete(friend)
    }
    override suspend fun deleteAll(){
        friendLocalDataSource.deleteAll()
    }

    override fun getMBTIFeatures(mbti: MBTI): List<MBTIFeatures> {
        return friendLocalDataSource.getMBTIFeatures(mbti)
    }
}