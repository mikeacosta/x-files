package net.acosta.mike.xfiles.network

import io.reactivex.Single
import net.acosta.mike.xfiles.data.Episodes
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RestClient {

    private val api: XfilesApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://demo3886988.mockable.io")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        api = retrofit.create(XfilesApi::class.java)
    }

    fun getEpisodes() : Single<Episodes> {
        return api.getData()
    }
}