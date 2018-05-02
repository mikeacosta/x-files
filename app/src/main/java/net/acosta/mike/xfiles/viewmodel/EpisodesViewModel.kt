package net.acosta.mike.xfiles.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import net.acosta.mike.xfiles.data.Episode
import net.acosta.mike.xfiles.repository.EpisodeRepository

class EpisodesViewModel(private val repository: EpisodeRepository) : ViewModel() {

    private lateinit var episodes: MutableLiveData<List<Episode>>

    fun getEpisodes(season: Int) : LiveData<List<Episode>> {

        if (!this::episodes.isInitialized)
            episodes = repository.getEpisodeList(season)

        return episodes
    }
}