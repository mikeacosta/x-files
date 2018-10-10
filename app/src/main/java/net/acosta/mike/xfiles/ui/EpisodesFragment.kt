package net.acosta.mike.xfiles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import net.acosta.mike.xfiles.R
import net.acosta.mike.xfiles.adapter.DataAdapter
import net.acosta.mike.xfiles.databinding.EpisodesFragmentBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.episodes_fragment.view.*
import net.acosta.mike.xfiles.viewmodel.EpisodesViewModel
import org.koin.android.ext.android.inject


class EpisodesFragment : Fragment()  {
    private var season : Int = 0
    private val viewModel: EpisodesViewModel by inject()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        season = arguments?.get("season") as Int
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<EpisodesFragmentBinding>(inflater, R.layout.episodes_fragment, container, false)
        val view : View  = binding.root

        recyclerView = view.recyclerViewEpisodes
        recyclerView.layoutManager = LinearLayoutManager(this@EpisodesFragment.activity)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getEpisodes(season).observe(viewLifecycleOwner, Observer { episodes ->
            if (recyclerView.adapter == null) {
                recyclerView.adapter =  DataAdapter(context!!, episodes ?: emptyList())
            }
        })
    }
}