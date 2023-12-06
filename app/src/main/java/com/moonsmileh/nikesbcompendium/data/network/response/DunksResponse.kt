package com.moonsmileh.nikesbcompendium.data.network.response

import com.moonsmileh.nikesbcompendium.domain.model.Silhouette
import com.moonsmileh.nikesbcompendium.domain.model.Dunks

data class DunksResponse(
    val id: String,
    val name: String,
    val imageUrl: String,
    val silhouette: Silhouette
) {
    fun toDomain(): Dunks {
        return Dunks(id, name, imageUrl, silhouette)
    }
}
