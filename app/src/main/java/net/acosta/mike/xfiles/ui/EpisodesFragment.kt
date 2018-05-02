package net.acosta.mike.xfiles.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.acosta.mike.xfiles.R
import net.acosta.mike.xfiles.adapter.DataAdapter
import net.acosta.mike.xfiles.network.RestClient
import net.acosta.mike.xfiles.databinding.EpisodesFragmentBinding
import android.arch.lifecycle.Observer
import net.acosta.mike.xfiles.repository.EpisodeRepository
import net.acosta.mike.xfiles.viewmodel.EpisodesViewModel
import net.acosta.mike.xfiles.viewmodel.ViewModelFactory


class EpisodesFragment : Fragment()  {
    private var season : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        season = arguments.get("season") as Int
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<EpisodesFragmentBinding>(inflater, R.layout.episodes_fragment, container, false)
        val view : View  = binding.root
        val recyclerView : RecyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this@EpisodesFragment.activity)

        val api = RestClient()
        val repo = EpisodeRepository(api)

        val viewModel = ViewModelProviders.of(this, ViewModelFactory(repo))
                .get(EpisodesViewModel::class.java)
        viewModel.getEpisodes(season).observe(this, Observer { episodes ->
            if (recyclerView.adapter == null) {
                recyclerView.adapter =  DataAdapter(this.activity, episodes ?: emptyList())
            }
        })

        return view
    }
}