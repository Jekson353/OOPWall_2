package ru.wall
import java.util.*


fun main() {
    val calendar = Calendar.getInstance()
    val timestamp = calendar.timeInMillis
    val post = Post(
            id = 1,
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = timestamp,
            text = "Новый пост 1",
            replyPostId = 10,
            comments = "",
            copyright = "",
            likes = 0,
            views = 0,
            postType = "",
            signerId = 0,
    )
    println("Первый пост: $post")
    WallService.add(post)
    val twoPost = Post(
            id = 2,
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = timestamp,
            text = "Новый пост 2",
            replyPostId = 10,
            comments = "",
            copyright = "",
            likes = 0,
            views = 0,
            postType = "",
            signerId = 0,
    )
    println("Второй пост: $twoPost")
    WallService.add(twoPost)
    val result1 = WallService.getPost(id = 2)
    println("Пост до изменения: $result1")
    val updatedPost = twoPost.copy(likes = 10)
    WallService.update(updatedPost)

    val result2 = WallService.getPost(id = 2)
    println("Пост после изменения: $result2")
}