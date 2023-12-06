package com.moonsmileh.nikesbcompendium.domain

import com.moonsmileh.nikesbcompendium.domain.model.DunkDetail

interface NikeSBRepository {
    suspend fun getDunkById(id: String): DunkDetail?
}