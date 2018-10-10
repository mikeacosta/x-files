package net.acosta.mike.xfiles.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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