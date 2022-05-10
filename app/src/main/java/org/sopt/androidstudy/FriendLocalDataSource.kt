package org.sopt.androidstudy

import androidx.lifecycle.LiveData
import org.sopt.androidstudy.data.models.types.MBTI
import org.sopt.androidstudy.data.models.types.MBTIFeatures
import org.sopt.androidstudy.db.Friend
import org.sopt.androidstudy.db.FriendDAO

class FriendLocalDataSource(private val dao: FriendDAO) {

    val friends = dao.getAllFriends()

    fun getAll(): LiveData<List<Friend>> {
            return friends
    }

    suspend fun insert(friend: Friend) {
        dao.insertFriend(friend)
    }

    suspend fun update(friend: Friend) {
        dao.updateFriend(friend)
    }

    suspend fun delete(friend: Friend) {
        dao.deleteFriend(friend)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

    fun getMBTIFeatures(mbti: MBTI): List<MBTIFeatures> {
        // TODO mbti에 따라 mbti 특성을 list 형태로 반환해보세요! 각 mbti별 특성은 총 3개 입니다~
        // 어느정도 작성하시다가 도저히 귀찮아서 작성을 못하겠다? 그럼 저를 호출해 보세요 ㅎㅎ 좋은일이 있을 수도!
        return when (mbti) {
            MBTI.INFJ -> listOf(MBTIFeatures.INFJ1, MBTIFeatures.INFJ2, MBTIFeatures.INFJ3)
            MBTI.INFP -> listOf(MBTIFeatures.INFP1, MBTIFeatures.INFP2, MBTIFeatures.INFP3)
            MBTI.INTJ -> listOf(MBTIFeatures.INTJ1, MBTIFeatures.INTJ2, MBTIFeatures.INTJ3)
            MBTI.INTP -> listOf(MBTIFeatures.INTP1, MBTIFeatures.INTP2, MBTIFeatures.INTP3)

            MBTI.ISFJ -> listOf(MBTIFeatures.ISFJ1, MBTIFeatures.ISFJ2, MBTIFeatures.INFJ3)
            MBTI.ISFP -> listOf(MBTIFeatures.ISFP1, MBTIFeatures.ISFP2, MBTIFeatures.ISFP3)
            MBTI.ISTJ -> listOf(MBTIFeatures.ISTJ1, MBTIFeatures.ISTJ2, MBTIFeatures.ISTJ3)
            MBTI.ISTP -> listOf(MBTIFeatures.ISTP1, MBTIFeatures.ISTP2, MBTIFeatures.ISTP3)

            MBTI.ENFJ -> listOf(MBTIFeatures.ENFJ1, MBTIFeatures.ENFJ2, MBTIFeatures.ENFJ3)
            MBTI.ENFP -> listOf(MBTIFeatures.ENFP1, MBTIFeatures.ENFP2, MBTIFeatures.ENFP3)
            MBTI.ENTJ -> listOf(MBTIFeatures.ENTJ1, MBTIFeatures.ENTJ2, MBTIFeatures.ENTJ3)
            MBTI.ENTP -> listOf(MBTIFeatures.ENTP1, MBTIFeatures.ENTP2, MBTIFeatures.ENTP3)

            MBTI.ESFJ -> listOf(MBTIFeatures.ESFJ1, MBTIFeatures.ESFJ2, MBTIFeatures.ESFJ3)
            MBTI.ESFP -> listOf(MBTIFeatures.ESFP1, MBTIFeatures.ESFP2, MBTIFeatures.ESFP3)
            MBTI.ESTJ -> listOf(MBTIFeatures.ESTJ1, MBTIFeatures.ESTJ2, MBTIFeatures.ESTJ3)
            MBTI.ESTP -> listOf(MBTIFeatures.ESTP1, MBTIFeatures.ESTP2, MBTIFeatures.ESTP3)
        }

    }

}