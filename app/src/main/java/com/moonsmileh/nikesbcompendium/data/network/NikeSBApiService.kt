package com.moonsmileh.nikesbcompendium.data.network

import com.moonsmileh.nikesbcompendium.data.network.response.DunkDetailResponse
import com.moonsmileh.nikesbcompendium.data.network.response.DunksResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NikeSBApiService {

    @GET("getAllDunks")
    suspend fun getAllDunks(): List<DunksResponse>

    @GET("dunks/{id}")
    suspend fun getDunkById(@Path("id") id: String): DunkDetailResponse

}