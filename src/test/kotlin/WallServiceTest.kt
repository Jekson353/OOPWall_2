package ru.wall

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        val post = Post(
            id = 10,
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = 0,
            text = "Новый пост 1",
            replyPostId = 10,
            comments = "",
            copyright = "",
            likes = 0,
            views = 0,
            postType = "",
            signerId = 0,
        )
        val result = service.add(post)
        assertEquals(result, post)
    }


    @Test
    fun update() {
        val service = WallService
        val post = Post(
            id = 1,
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = 0,
            text = "Новый пост 1",
            replyPostId = 10,
            comments = "",
            copyright = "",
            likes = 0,
            views = 0,
            postType = "",
            signerId = 0,
        )
        service.add(Post(id=1,ownerId = 10,createdBy = 0, date = 0, fromId = 10))
        val result = service.update(post)
        assertTrue(result)
    }

    @Test
    fun getPost() {
        val result = WallService.getPost(id = 20)
        assertEquals(result, "Пост с таким ID не найден.")
    }
}