package net.acosta.mike.xfiles.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import net.acosta.mike.xfiles.repository.EpisodeRepository

class ViewModelFactory(private val repository: EpisodeRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return EpisodesViewModel(repository) as T
    }

}