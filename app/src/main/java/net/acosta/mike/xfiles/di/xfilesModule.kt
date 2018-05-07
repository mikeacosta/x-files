package net.acosta.mike.xfiles.di

import net.acosta.mike.xfiles.network.RestClient
import net.acosta.mike.xfiles.repository.EpisodeRepository
import net.acosta.mike.xfiles.viewmodel.EpisodesViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext


val dataModule: Module = applicationContext {
    bean { EpisodeRepository(get()) }
    factory { RestClient() }
}

val viewModelModule: Module = applicationContext {
    viewModel { EpisodesViewModel(get()) }
    bean { EpisodeRepository(get()) }
    factory { RestClient() }
}