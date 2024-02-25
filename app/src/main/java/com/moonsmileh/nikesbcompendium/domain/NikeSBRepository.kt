package com.moonsmileh.nikesbcompendium.domain

import com.moonsmileh.nikesbcompendium.domain.model.Dunk
import com.moonsmileh.nikesbcompendium.domain.model.DunkDetail

interface NikeSBRepository {

    suspend fun getAllDunks(): List<Dunk>?
    suspend fun getDunkById(id: String): DunkDetail?
}