package net.acosta.mike.xfiles.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import net.acosta.mike.xfiles.R
import net.acosta.mike.xfiles.BR
import net.acosta.mike.xfiles.data.Episode
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.CardView
import android.util.Log
import java.io.BufferedInputStream
import java.io.IOException
import java.net.URL


class DataAdapter(private val context: Context, private val dataList : List<Episode>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val episode: Episode = dataList[position]
        holder?.binding?.setVariable(BR.episode, episode)

        holder?.bind(context, episode, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        //val view = LayoutInflater.from(parent?.context).inflate(R.layout.episode_card, parent, false)

        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent?.context),
                R.layout.episode_card,
                parent, false)

        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = dataList.count()

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ViewDataBinding>(view)

        val cardView = view.findViewById<CardView>(R.id.card_view)
        val imageView = view.findViewById<ImageView>(R.id.item_image)

        fun bind(context: Context, episode: Episode, position: Int) {
            cardView?.setOnClickListener({v ->
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(episode.url)))
            })

            when {
                position % 4 == 0 -> imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.xfilesavatar))
                position % 3 == 0 -> imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.agents))
                position % 2 == 0 -> imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.alien))
                else -> imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.believe))
            }
        }
    }
}