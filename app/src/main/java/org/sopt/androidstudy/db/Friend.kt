package org.sopt.androidstudy.db

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.sopt.androidstudy.data.models.types.MBTI

@Parcelize
@Entity(tableName = "friend_data_table")
data class Friend(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "friend_id")
    val id: Int,

    @ColumnInfo(name = "friend_name")
    var name: String,

    @ColumnInfo(name = "friend_email")
    val email: String,

    @ColumnInfo(name = "friend_mbti")
    val mbti: MBTI?
): Parcelable