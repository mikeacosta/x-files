package net.acosta.mike.xfiles.data


data class Episode(val season: Int, val episode: Int, val title: String, val url: String,
                   val date: String, val type: EpisodeType, val imageurl: String)

data class Episodes(val items: List<Episode>)
