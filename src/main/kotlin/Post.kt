package ru.wall

data class Post(
        val id: Int? = null,
        val ownerId: Int,
        val fromId: Int,
        val createdBy: Int,
        val date: Long,
        val text: String = "",
        val replyPostId: Int = 0,
        val friendsOnly: Boolean = false,
        val comments: String = "",
        val copyright: String = "",
        val likes: Int = 0,
        val views: Int = 0,
        val postType: String = "",
        val signerId: Int = 0,
        val canPin: Boolean = false,
        val canDelete: Boolean = false,
        val isPinned: Boolean = false,
        val markedAsAds: Boolean = false
)