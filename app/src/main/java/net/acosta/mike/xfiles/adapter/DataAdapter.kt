package net.acosta.mike.xfiles.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.acosta.mike.xfiles.R
import net.acosta.mike.xfiles.BR
import net.acosta.mike.xfiles.data.Episode


class DataAdapter(private val dataList : List<Episode>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val episode: Episode = dataList[position]
        holder?.binding?.setVariable(BR.episode, episode)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        //val view = LayoutInflater.from(parent?.context).inflate(R.layout.episode_list_item, parent, false)

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent?.context),
                R.layout.episode_card,
                parent, false)

        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = dataList.count()

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val binding = DataBindingUtil.bind<ViewDataBinding>(view)

//        fun bind(episode: Episode, position: Int) {
//            itemView.tv_season.text = episode.season.toString()
//            itemView.tv_date.text = episode.date.toString()
//            itemView.tv_episode.text = episode.episode.toString()
//            itemView.tv_title.text = episode.title
//            itemView.tv_type.text = episode.type.toString()
//
//            itemView.ib_imdb.setOnClickListener { v -> startActivity(itemView.context,
//                    Intent(Intent.ACTION_VIEW, Uri.parse(episode.imdb)), null) }
//        }
    }
}