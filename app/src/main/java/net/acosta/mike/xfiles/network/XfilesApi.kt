package net.acosta.mike.xfiles.network

import io.reactivex.Observable
import net.acosta.mike.xfiles.data.Episodes
import retrofit2.http.GET

/**
 * Created by Mike on 1/23/2018.
 */
interface XfilesApi {

    @GET("/api/xfiles")
    fun getData() : Observable<Episodes>
}