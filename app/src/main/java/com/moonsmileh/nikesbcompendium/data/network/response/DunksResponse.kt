package com.moonsmileh.nikesbcompendium.data.network.response

import com.moonsmileh.nikesbcompendium.domain.model.Dunk

data class DunksResponse(
    val id: String,
    val name: String,
    val imageUrl: String,
    val silhouette: String,
    val releasedDate: String
) {
    fun toDomain(): Dunk {
        return Dunk(id, name, imageUrl, silhouette, releasedDate)
    }
}
