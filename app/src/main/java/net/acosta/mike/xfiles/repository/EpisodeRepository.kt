package net.acosta.mike.xfiles.repository

import net.acosta.mike.xfiles.data.Episode
import net.acosta.mike.xfiles.network.RestClient
import android.arch.lifecycle.MutableLiveData
import io.reactivex.schedulers.Schedulers


class EpisodeRepository(private val client: RestClient) {

    fun getEpisodeList(season: Int): MutableLiveData<List<Episode>> {
        val episodes = MutableLiveData<List<Episode>>()

        client.getEpisodes().subscribeOn(Schedulers.io())
                .subscribe ({
                    result ->
                    episodes.postValue(result.items
                            .filter{ it.season == season }
                            .sortedWith(compareBy({ it.season }, { it.episode }))
                    )
                }, { error ->
                    error.printStackTrace()
                })

        return episodes
    }
}