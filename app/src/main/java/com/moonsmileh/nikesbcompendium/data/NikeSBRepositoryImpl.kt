package com.moonsmileh.nikesbcompendium.data

import com.moonsmileh.nikesbcompendium.data.network.NikeSBApiService
import com.moonsmileh.nikesbcompendium.domain.NikeSBRepository
import com.moonsmileh.nikesbcompendium.domain.model.Dunk
import com.moonsmileh.nikesbcompendium.domain.model.DunkDetail
import javax.inject.Inject

class NikeSBRepositoryImpl @Inject constructor(private val apiService: NikeSBApiService) :
    NikeSBRepository {

    override suspend fun getAllDunks(): List<Dunk>? {

        kotlin.runCatching {
            apiService.getAllDunks()
        }
            .onSuccess { return it.map { it.toDomain() } }
            .onFailure { }
        return null
    }

    override suspend fun getDunkById(id: String): DunkDetail? {

        kotlin.runCatching {
            apiService.getDunkById(id)
        }.onSuccess {
            return it.toDomain()
        }.onFailure {

        }
        return null
    }
}