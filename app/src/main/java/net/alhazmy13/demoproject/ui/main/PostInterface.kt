package net.alhazmy13.demoproject.ui.main

import net.alhazmy13.demoproject.model.PostModel
import net.alhazmy13.demoproject.ui.ViewInterface


interface PostInterface:ViewInterface{

    fun onPostsLoaded(posts: List<PostModel>)
}