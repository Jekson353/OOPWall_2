package ru.wall

import java.lang.RuntimeException

object WallService {
    private var posts = emptyArray<Post>()

    private fun getNumberPost(): Int{
        return posts.lastIndex+1
    }

    fun add(post: Post): Post {
        if (posts.isNotEmpty()) {
            for (i: Int in 0..posts.size) {
                val searchPost = posts[i]
                if (post.id == searchPost.id) {
                    break
                } else {
                    posts += post.copy(id=getNumberPost())
                    return posts.last()
                }
            }
            return posts.last()
        } else {
            posts += post.copy(id=getNumberPost())
            return posts.last()
        }
    }

    fun update(post: Post): Boolean {
        if (posts.isNotEmpty()) {
            for (i: Int in 0..posts.size) {
                val searchPost = posts[i]
                if (post.id == searchPost.id) {
                    val updatedPost = post.copy(
                            id = searchPost.id,
                            date = searchPost.date,
                    )
                    posts[i] = updatedPost
                    return true
                }
            }
            return false
        }
        return false
    }

    fun getPost(id: Int): Post {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                return posts[index]
            }
        }
        throw RuntimeException("Пост не найден!")
    }
}