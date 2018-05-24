package net.alhazmy13.demoproject.operations

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.alhazmy13.demoproject.model.PostModel
import net.alhazmy13.demoproject.network.Endpoints
import javax.inject.Inject


class PostsOperations @Inject constructor(private val endpoints: Endpoints) {

    fun getPosts():Single<List<PostModel>>{
        return endpoints.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

}