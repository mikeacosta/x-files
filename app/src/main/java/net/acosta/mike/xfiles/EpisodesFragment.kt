package net.acosta.mike.xfiles

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.acosta.mike.xfiles.adapter.DataAdapter
import net.acosta.mike.xfiles.network.RestClient
import net.acosta.mike.xfiles.databinding.EpisodesFragmentBinding

class EpisodesFragment : Fragment()  {
    var season : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        season = arguments.get("season") as Int
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<EpisodesFragmentBinding>(inflater, R.layout.episodes_fragment, container, false)
        val view : View  = binding.root
        val recyclerView : RecyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this.activity)

        val api = RestClient()
        api.getEpisodes().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->
                        this@EpisodesFragment.activity.runOnUiThread {
                            recyclerView.adapter =
                                DataAdapter(this.activity,
                                        result.items
                                                .filter{ it.season == season }
                                                .sortedWith(compareBy({ it.season }, { it.episode }))
                                )
                    }
                }, { error ->
                    error.printStackTrace()
                })

        return view
    }
}