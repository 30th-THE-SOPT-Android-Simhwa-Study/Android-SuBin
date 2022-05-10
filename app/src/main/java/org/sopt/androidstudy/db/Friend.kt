package org.sopt.androidstudy.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friend_data_table")
data class Friend(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "friend_id")
    val id: Int,

    @ColumnInfo(name = "friend_name")
    val name: String,

    @ColumnInfo(name = "friend_email")
    val email: String,

    @ColumnInfo(name = "friend_mbti")
    val mbti: String
)