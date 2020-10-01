package ru.wall
import java.util.*


fun main() {
    val calendar = Calendar.getInstance()
    val timestamp = calendar.timeInMillis
    val post = Post(
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = timestamp,
            text = "Новый пост 1",
            replyPostId = 10,
            comments = "",
            copyright = "",
            postType = "",
            signerId = 0,
    )
    println("Оригинал первого поста: $post")
    WallService.add(post)
    val post1 = WallService.getPost(id = 0)
    println("Внесен в базу как: $post1")

    val twoPost = Post(
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = timestamp,
            text = "Новый пост 2",
            replyPostId = 10,
            comments = "",
            copyright = "",
            postType = "",
            signerId = 0,
    )
    println("Второй пост: $twoPost")
    WallService.add(twoPost)
    val post2 = WallService.getPost(id = 1)
    println("Внесен в базу как: $post2")


    val result1 = WallService.getPost(id = 1)
    println("Пост до изменения: $result1")
    val updatedPost = result1.copy(text = "Новый текст поста", likes = 10)
    WallService.update(updatedPost)

    val result2 = WallService.getPost(id = 1)
    println("Пост после изменения: $result2")
}
