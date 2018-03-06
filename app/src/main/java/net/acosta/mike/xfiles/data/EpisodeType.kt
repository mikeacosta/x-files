package net.acosta.mike.xfiles.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Mike on 1/27/2018.
 */
enum class EpisodeType {
    @SerializedName("0")
    Conspiracy,
    @SerializedName("1")
    TopMonsterOfTheWeek,
    @SerializedName("2")
    Other
}