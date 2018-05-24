package net.alhazmy13.demoproject.ui.main

import net.alhazmy13.demoproject.operations.PostsOperations
import javax.inject.Inject


class MainPresenter @Inject constructor(private val postsOperations: PostsOperations) {

    fun getAllPosts(postInterface: PostInterface) {
        postsOperations.getPosts()
                .subscribe({ result -> postInterface.onPostsLoaded(result) },
                        { error -> postInterface.onError(error.message ?: "Unknown error") })
    }

}