package net.acosta.mike.xfiles.data


data class Episode(val season: Int, val episode: Int, val title: String, val imdb: String,
                   val date: String, val type: EpisodeType)

data class Episodes(val items: List<Episode>)
