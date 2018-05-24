package net.alhazmy13.demoproject.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import net.alhazmy13.demoproject.model.PostModel
import net.alhazmy13.demoproject.operations.PostsOperations
import javax.inject.Inject


class MainViewModel @Inject constructor(private val postsOperations: PostsOperations) : ViewModel() {

    private var posts: MutableLiveData<List<PostModel>>? = null

    fun getPosts(): LiveData<List<PostModel>> {
        if (posts == null) {
            posts = MutableLiveData()
        }
        getAllPosts()

        return posts as MutableLiveData<List<PostModel>>
    }

    private fun getAllPosts() {
        postsOperations.getPosts()
                .subscribe({ result -> posts?.postValue(result) })
    }
}