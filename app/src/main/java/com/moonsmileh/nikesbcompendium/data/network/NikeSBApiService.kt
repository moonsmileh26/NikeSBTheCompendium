package com.moonsmileh.nikesbcompendium.data.network

import com.moonsmileh.nikesbcompendium.data.network.response.DunkDetailResponse
import com.moonsmileh.nikesbcompendium.data.network.response.DunksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NikeSBApiService {

    @GET("getAllDunks")
    suspend fun getAllDunks(): List<DunksResponse>

    @GET("getDunkById")
    suspend fun getDunkById(@Query("id") id: String): DunkDetailResponse

}