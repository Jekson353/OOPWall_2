object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        if (posts.isNotEmpty()) {
            for (i: Int in 0..posts.size) {
                val searchPost = posts[i]
                if (post.id == searchPost.id) {
                    break
                } else {
                    posts += post
                    return posts.last()
                }
            }
            return posts.last()
        } else {
            posts += post
            return posts.last()
        }
    }

    fun update(post: Post): Boolean {
        if (posts.isNotEmpty()) {
            for (i: Int in 0..posts.size) {
                val searchPost = posts[i]
                if (post.id == searchPost.id) {
                    val updatedPost = searchPost.copy(
                            ownerId = post.ownerId,
                            fromId = post.fromId,
                            createdBy = post.createdBy,
                            text = post.text,
                            replyPostId = post.replyPostId,
                            friendsOnly = post.friendsOnly,
                            comments = post.comments,
                            copyright = post.copyright,
                            likes = post.likes,
                            views = post.views,
                            postType = post.postType,
                            signerId = post.signerId,
                            canPin = post.canPin,
                            canDelete = post.canDelete,
                            isPinned = post.isPinned,
                            markedAsAds = post.markedAsAds
                    )
                    posts[i] = updatedPost
                    return true
                }
            }
            return false
        }
        return false
    }

    fun getPost(id: Long): String {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                return posts[index].toString()
            }
        }
        return "Пост с таким ID не найден."
    }
}