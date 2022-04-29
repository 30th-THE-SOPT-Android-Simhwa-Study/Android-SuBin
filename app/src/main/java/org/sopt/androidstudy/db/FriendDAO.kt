package org.sopt.androidstudy.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FriendDAO {
    @Insert
    suspend fun insertFriend(Friend: Friend): Long

    @Update
    suspend fun updateFriend(Friend: Friend)

    @Delete
    suspend fun deleteFriend(Friend: Friend)

    @Query("DELETE FROM friend_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM friend_data_table")
    fun getAllFriends(): LiveData<List<Friend>>
}