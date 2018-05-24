package net.alhazmy13.demoproject.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.alhazmy13.demoproject.R
import net.alhazmy13.demoproject.model.PostModel
import net.alhazmy13.demoproject.util.app
import net.alhazmy13.demoproject.viewmodel.ViewModelFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity(), PostInterface {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var postsAdapter: PostsAdapter
    private val posts = arrayListOf<PostModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.applicationComponent.inject(this)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPosts().observe(this, Observer(::updatePosts))

    }

    private fun setupRecyclerView() {
        postsAdapter = PostsAdapter(posts)
        activy_main_post_recycler_view.layoutManager = LinearLayoutManager(this)
        activy_main_post_recycler_view.adapter = postsAdapter
    }

    override fun onPostsLoaded(posts: List<PostModel>) {
        this.posts.addAll(posts)
        postsAdapter.notifyDataSetChanged()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun updatePosts(posts: List<PostModel>?) {
        posts?.let {
            this.posts.addAll(it)
            postsAdapter.notifyDataSetChanged()
        }

    }

//    private fun updatePosts(posts:List<PostModel>){
//
//    }

    //    private var listView: ListView? = null
//    private var adapter: SimpleArrayAdapter? = null
//    private val dataSet: MutableList<PostModel> = ArrayList()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        listView = findViewById(R.id.listView)
//        adapter = SimpleArrayAdapter(dataSet)
//        listView!!.adapter = adapter
//
//        DownloadTask().execute("https://jsonplaceholder.typicode.com/posts")
//
//    }
//
//    private inner class DownloadTask : AsyncTask<String, Void, List<PostModel>>() {
//
//        override fun doInBackground(vararg params: String): List<PostModel> {
//            Log.d("TAG",params[0])
//            val connection = URL(params[0]).openConnection() as HttpURLConnection
//            connection.requestMethod = "GET"
//            connection.connect()
//            val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
//
//            val response = Gson().fromJson(bufferedReader, Array<PostModel>::class.java).asList()
//            return response
//
//
//        }
//
//        override fun onPostExecute(response: List<PostModel>) {
//            //Here you are done with the task
//
//            dataSet.clear()
//            dataSet.addAll(response)
//            adapter!!.notifyDataSetChanged()
//
//        }
//    }
//
//
//    inner class SimpleArrayAdapter(private val values: MutableList<PostModel>) : ArrayAdapter<PostModel>(this@MainActivity, -1, values) {
//
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//            val inflater = context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            val rowView = inflater.inflate(R.layout.item_post, parent, false)
//            val body: TextView = rowView.findViewById(R.id.txt_body)
//            val title: TextView = rowView.findViewById(R.id.txt_title)
//            body.text = values.get(position).getBody()
//            title.text = values.get(position).getTitle()
//
//            return rowView
//        }
//    }
}


