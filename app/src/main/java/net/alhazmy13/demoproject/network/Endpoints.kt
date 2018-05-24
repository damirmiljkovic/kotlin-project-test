package net.alhazmy13.demoproject.network

import io.reactivex.Single
import net.alhazmy13.demoproject.model.PostModel
import retrofit2.http.GET


interface Endpoints {

    @GET("posts")
    fun getPosts(): Single<List<PostModel>>
}