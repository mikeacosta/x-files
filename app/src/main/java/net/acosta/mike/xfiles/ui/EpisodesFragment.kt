package net.acosta.mike.xfiles.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.acosta.mike.xfiles.R
import net.acosta.mike.xfiles.adapter.DataAdapter
import net.acosta.mike.xfiles.databinding.EpisodesFragmentBinding
import android.arch.lifecycle.Observer
import kotlinx.android.synthetic.main.episodes_fragment.view.*
import net.acosta.mike.xfiles.viewmodel.EpisodesViewModel
import org.koin.android.ext.android.inject


class EpisodesFragment : Fragment()  {
    private var season : Int = 0

    private val viewModel: EpisodesViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        season = arguments.get("season") as Int
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<EpisodesFragmentBinding>(inflater, R.layout.episodes_fragment, container, false)
        val view : View  = binding.root

        view.recyclerViewEpisodes.layoutManager = LinearLayoutManager(this@EpisodesFragment.activity)

        viewModel.getEpisodes(season).observe(this, Observer { episodes ->
            if (view.recyclerViewEpisodes.adapter == null) {
                view.recyclerViewEpisodes.adapter =  DataAdapter(this.activity, episodes ?: emptyList())
            }
        })

        return view
    }
}